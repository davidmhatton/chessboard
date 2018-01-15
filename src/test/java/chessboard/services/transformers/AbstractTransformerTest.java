package chessboard.services.transformers;

import org.junit.Test;

import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.AbstractTransformer.coordinateOutOfBounds;
import static chessboard.services.transformers.AbstractTransformer.squareOutOfBounds;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for top level transformer logic.
 *
 * @author David Hatton
 */
public class AbstractTransformerTest {

	@Test
	public void highSquareIsOutOfBounds() {
		assertThat(squareOutOfBounds(65)).isTrue();
	}

	@Test
	public void negativeSquareIsOutOfBounds() {
		assertThat(squareOutOfBounds(-2)).isTrue();
	}

	@Test
	public void goodSquareIsWithinBounds() {
		assertThat(squareOutOfBounds(43)).isFalse();
	}

	@Test
	public void tooFarAIsOutOfBounds() {
		final Coordinate testCoordinate = new Coordinate(-2, 2);
		assertThat(coordinateOutOfBounds(testCoordinate)).isTrue();
	}

	@Test
	public void tooFarHIsOutOfBounds() {
		final Coordinate testCoordinate = new Coordinate(10, 2);
		assertThat(coordinateOutOfBounds(testCoordinate)).isTrue();
	}

	@Test
	public void tooFarUpIsOutOfBounds() {
		final Coordinate testCoordinate = new Coordinate(2, 10);
		assertThat(coordinateOutOfBounds(testCoordinate)).isTrue();
	}

	@Test
	public void tooFarDownIsOutOfBounds() {
		final Coordinate testCoordinate = new Coordinate(2, -2);
		assertThat(coordinateOutOfBounds(testCoordinate)).isTrue();
	}

	@Test
	public void goodCoordinateWithinBounds() {
		final Coordinate testCoordinate = new Coordinate(2, 2);
		assertThat(coordinateOutOfBounds(testCoordinate)).isFalse();
	}
}