package chessboard.services.transformers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test suite for diagonal transformation.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class DiagonalTransformerTest {

	private Coordinate originCoordinate;
	private DiagonalTransformer diagonalTransformer;

	private static final int BIG_DISTANCE = 7;
	private static final int LITTLE_DISTANCE = 3;

	@Before
	public void setUp() {
		originCoordinate = new Coordinate(3,3);
		diagonalTransformer = new DiagonalTransformer();
	}

	@Test
	public void upThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void aThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.A)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void hThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.H)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upATooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, BIG_DISTANCE, Direction.UP_A)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void upAReturnsCorrectCoordinates() throws Exception {
		Coordinate actualDestination = diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP_A);
		Coordinate expectedDestination = new Coordinate(
				originCoordinate.getFileId() - LITTLE_DISTANCE,
				originCoordinate.getRankId() + LITTLE_DISTANCE
		);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}

	@Test
	public void upHTooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, BIG_DISTANCE, Direction.UP_H)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void upHReturnsCorrectCoordinates() throws Exception {
		Coordinate actualDestination = diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP_H);
		Coordinate expectedDestination = new Coordinate(
				originCoordinate.getFileId() + LITTLE_DISTANCE,
				originCoordinate.getRankId() + LITTLE_DISTANCE
		);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}

	@Test
	public void downATooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, BIG_DISTANCE, Direction.DOWN_A)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void downAReturnsCorrectCoordinates() throws Exception {
		Coordinate actualDestination = diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN_A);
		Coordinate expectedDestination = new Coordinate(
				originCoordinate.getFileId() - LITTLE_DISTANCE,
				originCoordinate.getRankId() - LITTLE_DISTANCE
		);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}


	@Test
	public void downHTooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonalTransformer.diagonal(originCoordinate, BIG_DISTANCE, Direction.DOWN_H)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void downHReturnsCorrectCoordinates() throws Exception {
		Coordinate actualDestination = diagonalTransformer.diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN_H);
		Coordinate expectedDestination = new Coordinate(
				originCoordinate.getFileId() + LITTLE_DISTANCE,
				originCoordinate.getRankId() - LITTLE_DISTANCE
		);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}
}