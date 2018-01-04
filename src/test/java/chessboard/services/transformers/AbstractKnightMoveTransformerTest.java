package chessboard.services.transformers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.AbstractKnightMoveTransformer.knightMove;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Knight move tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AbstractKnightMoveTransformerTest {

	/*
		Knight moves id reference key:
		{
			0: UUH,
			1: UHH,
			2: DHH,
			3: DDH,
			4: DDA,
			5: DAA,
			6: UAA,
			7: UUA
		}
		The directions in jumps are entirely commutative.
	 */

	private Coordinate origin;
	private List<Direction> jumps;

	@Before
	public void setUp() throws Exception {
		jumps = new ArrayList<Direction>();
	}

	@Test
	public void knightMoveBeyondBoardThrowsOutOfBoundsException() {
		jumps.add(Direction.A);
		jumps.add(Direction.A);
		jumps.add(Direction.UP);

		origin = new Coordinate(0,0);

		assertThatThrownBy(() -> {
			knightMove(origin, jumps);
		}).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void badDirectionInJumpsThrowsWrongDirectionException() {
		jumps.add(Direction.A);
		jumps.add(Direction.A);
		jumps.add(Direction.UP_A);

		origin = new Coordinate(3,3);

		assertThatThrownBy(() -> {
			knightMove(origin, jumps);
		}).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates0() throws Exception {

	}
}