package chessboard.services.transformers;

import java.util.Arrays;
import java.util.List;

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
		This test package references knight move combos by number as a shorthand.
		Knight moves id reference key:
		{
			0: (Up, Up, H),
			1: (Up, H, H),
			2: (Down, H, H),
			3: (Down, Down, H),
			4: (Down, Down, A),
			5: (Down, A, A),
			6: (Up, A, A),
			7: (Up, Up, A)
		}
		The directions in jumps are entirely commutative.
	 */

	private static final List<List<Direction>> MOVE_LISTS = Arrays.asList(
			Arrays.asList(Direction.UP, Direction.UP, Direction.H),
			Arrays.asList(Direction.UP, Direction.H, Direction.H),
			Arrays.asList(Direction.DOWN, Direction.H, Direction.H),
			Arrays.asList(Direction.DOWN, Direction.DOWN, Direction.H),
			Arrays.asList(Direction.DOWN, Direction.DOWN, Direction.A),
			Arrays.asList(Direction.DOWN, Direction.A, Direction.A),
			Arrays.asList(Direction.UP, Direction.A, Direction.A),
			Arrays.asList(Direction.UP, Direction.UP, Direction.A)
	);

	private Coordinate origin;

	@Test
	public void knightMoveBeyondBoardThrowsOutOfBoundsException() {
		origin = new Coordinate(0, 0);

		assertThatThrownBy(() -> knightMove(origin, MOVE_LISTS.get(6))).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void badDirectionInJumpsThrowsWrongDirectionException() {
		final List<Direction> jumps = Arrays.asList(Direction.DOWN_A, Direction.H, Direction.H);
		origin = new Coordinate(3, 3);

		assertThatThrownBy(() -> knightMove(origin, jumps)).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates0() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(0));
		Coordinate expected = new Coordinate(origin.getFileId() + 1, origin.getRankId() + 2);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates1() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(1));
		Coordinate expected = new Coordinate(origin.getFileId() + 2, origin.getRankId() + 1);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates2() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(2));
		Coordinate expected = new Coordinate(origin.getFileId() + 2, origin.getRankId() - 1);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates3() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(3));
		Coordinate expected = new Coordinate(origin.getFileId() + 1, origin.getRankId() - 2);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates4() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(4));
		Coordinate expected = new Coordinate(origin.getFileId() - 1, origin.getRankId() - 2);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates5() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(5));
		Coordinate expected = new Coordinate(origin.getFileId() - 2, origin.getRankId() - 1);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates6() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(6));
		Coordinate expected = new Coordinate(origin.getFileId() - 2, origin.getRankId() + 1);

		assertThat(destination).isEqualTo(expected);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates7() throws Exception {
		origin = new Coordinate(3, 3);
		Coordinate destination = knightMove(origin, MOVE_LISTS.get(7));
		Coordinate expected = new Coordinate(origin.getFileId() - 1, origin.getRankId() + 2);

		assertThat(destination).isEqualTo(expected);
	}
}