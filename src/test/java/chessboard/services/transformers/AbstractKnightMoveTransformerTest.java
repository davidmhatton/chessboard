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

	private static final List<Direction> KNIGHT_MOVE_0 = Arrays.asList(Direction.UP, Direction.UP, Direction.H);
	private static final List<Direction> KNIGHT_MOVE_1 = Arrays.asList(Direction.UP, Direction.H, Direction.H);
	private static final List<Direction> KNIGHT_MOVE_2 = Arrays.asList(Direction.DOWN, Direction.H, Direction.H);
	private static final List<Direction> KNIGHT_MOVE_3 = Arrays.asList(Direction.DOWN, Direction.DOWN, Direction.H);
	private static final List<Direction> KNIGHT_MOVE_4 = Arrays.asList(Direction.DOWN, Direction.DOWN, Direction.A);
	private static final List<Direction> KNIGHT_MOVE_5 = Arrays.asList(Direction.DOWN, Direction.A, Direction.A);
	private static final List<Direction> KNIGHT_MOVE_6 = Arrays.asList(Direction.UP, Direction.A, Direction.A);
	private static final List<Direction> KNIGHT_MOVE_7 = Arrays.asList(Direction.UP, Direction.UP, Direction.A);

	private Coordinate origin;

	@Test
	public void knightMoveBeyondBoardThrowsOutOfBoundsException() {
		origin = new Coordinate(0,0);

		assertThatThrownBy(() -> knightMove(origin, KNIGHT_MOVE_6)).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void badDirectionInJumpsThrowsWrongDirectionException() {
		final List<Direction> jumps = Arrays.asList(Direction.DOWN_A, Direction.H, Direction.H);
		origin = new Coordinate(3,3);

		assertThatThrownBy(() -> knightMove(origin, jumps)).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates0() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_0);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() + 1);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() + 2);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates1() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_1);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() + 2);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() + 1);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates2() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_2);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() + 2);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() - 1);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates3() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_3);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() + 1);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() - 2);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates4() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_4);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() - 1);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() - 2);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates5() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_5);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() - 2);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() - 1);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates6() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_6);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() - 2);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() + 1);
	}

	@Test
	public void knightMoveReturnsCorrectCoordinates7() throws Exception {
		origin = new Coordinate(3,3);
		Coordinate destination = knightMove(origin, KNIGHT_MOVE_7);

		assertThat(destination.getFileId()).isEqualTo(origin.getFileId() - 1);
		assertThat(destination.getRankId()).isEqualTo(origin.getRankId() + 2);
	}
}