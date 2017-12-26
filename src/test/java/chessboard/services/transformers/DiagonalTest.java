package chessboard.services.transformers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.Diagonal.diagonal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test suite for diagonal transformation.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class DiagonalTest {

	private Coordinate originCoordinate;

	private static final int BIG_DISTANCE = 7;
	private static final int LITTLE_DISTANCE = 3;

	@Before
	public void setUp() throws Exception {
		originCoordinate = new Coordinate(3,3);
	}

	@Test
	public void upThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void aThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, LITTLE_DISTANCE, Direction.A)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void hThrowsWrongDirectionException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, LITTLE_DISTANCE, Direction.H)
		).isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upATooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, BIG_DISTANCE, Direction.UP_A)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void upAReturnsCorrectCoordinates() throws Exception {
		Coordinate destination = diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP_A);

		assertThat(destination.getFileId()).isEqualTo(originCoordinate.getFileId() - LITTLE_DISTANCE);
		assertThat(destination.getRankId()).isEqualTo(originCoordinate.getRankId() + LITTLE_DISTANCE);
	}

	@Test
	public void upHTooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, BIG_DISTANCE, Direction.UP_H)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void upHReturnsCorrectCoordinates() throws Exception {
		Coordinate destination = diagonal(originCoordinate, LITTLE_DISTANCE, Direction.UP_H);

		assertThat(destination.getFileId()).isEqualTo(originCoordinate.getFileId() + LITTLE_DISTANCE);
		assertThat(destination.getRankId()).isEqualTo(originCoordinate.getRankId() + LITTLE_DISTANCE);
	}

	@Test
	public void downATooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, BIG_DISTANCE, Direction.DOWN_A)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void downAReturnsCorrectCoordinates() throws Exception {
		Coordinate destination = diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN_A);

		assertThat(destination.getFileId()).isEqualTo(originCoordinate.getFileId() - LITTLE_DISTANCE);
		assertThat(destination.getRankId()).isEqualTo(originCoordinate.getRankId() - LITTLE_DISTANCE);
	}


	@Test
	public void downHTooFarThrowsOutOfBoundsException() {
		assertThatThrownBy(
				() -> diagonal(originCoordinate, BIG_DISTANCE, Direction.DOWN_H)
		).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void downHReturnsCorrectCoordinates() throws Exception {
		Coordinate destination = diagonal(originCoordinate, LITTLE_DISTANCE, Direction.DOWN_H);

		assertThat(destination.getFileId()).isEqualTo(originCoordinate.getFileId() + LITTLE_DISTANCE);
		assertThat(destination.getRankId()).isEqualTo(originCoordinate.getRankId() - LITTLE_DISTANCE);
	}
}