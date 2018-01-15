package chessboard.services.transformers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.AbstractLateralTransformer.lateral;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Lateral movement tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AbstractLateralTransformerTest {

	private Coordinate originCoordinate;

	@Before
	public void setUp() {
		originCoordinate = new Coordinate(3,4);
	}

	@Test
	public void returnsCorrectCoordinateA() throws Exception {
		Coordinate expectedDestination = new Coordinate(1,4);
		Coordinate actualDestination = lateral(originCoordinate, 2, Direction.A);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}

	@Test
	public void returnsCorrectCoordinateH() throws Exception {
		Coordinate expectedDestination = new Coordinate(5,4);
		Coordinate actualDestination = lateral(originCoordinate, 2, Direction.H);

		assertThat(actualDestination).isEqualTo(expectedDestination);
	}

	@Test
	public void tooFarTowardAThrowsOutOfBoundsException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 6, Direction.A))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void tooFarTowardHThrowsOutOfBoundsException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 6, Direction.H))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void upThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.UP))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.DOWN))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.UP_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.UP_H))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.DOWN_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> lateral(originCoordinate, 2, Direction.DOWN_H))
				.isInstanceOf(WrongDirectionException.class);
	}
}