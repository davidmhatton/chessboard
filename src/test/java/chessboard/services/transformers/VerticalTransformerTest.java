package chessboard.services.transformers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Direction;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test suite for vertical motion.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class VerticalTransformerTest {

	private Coordinate originCoordinate;
	private VerticalTransformer verticalTransformer;

	@Before
	public void setUp() {
		originCoordinate = new Coordinate(3, 4);
		verticalTransformer = new VerticalTransformer();
	}

	@Test
	public void verticalWorksUp() throws Exception {
		final int testDistance = 2;
		Coordinate destinationCoordinate = verticalTransformer.vertical(originCoordinate, testDistance, Direction.UP);
		Coordinate expectedCoordinate = new Coordinate(originCoordinate.getFileId(), originCoordinate.getRankId() + testDistance);

		assertThat(destinationCoordinate).isEqualTo(expectedCoordinate);
	}

	@Test
	public void verticalWorksDown() throws Exception {
		final int testDistance = 2;
		Coordinate destinationCoordinate = verticalTransformer.vertical(originCoordinate, testDistance, Direction.DOWN);
		Coordinate expectedCoordinate = new Coordinate(originCoordinate.getFileId(), originCoordinate.getRankId() - testDistance);

		assertThat(destinationCoordinate).isEqualTo(expectedCoordinate);
	}

	@Test
	public void aheadFromEmptySquareThrowsNoPieceException() {
		final int testDistance = 2;
		assertThatThrownBy(
				() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.AHEAD)
		).isInstanceOf(NoPieceException.class);
	}

	@Test
	public void behindFromEmptySquareThrowsNoPieceException() {
		final int testDistance = 2;
		assertThatThrownBy(
				() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.BEHIND)
		).isInstanceOf(NoPieceException.class);
	}

	@Test
	public void absoluteMoveTooFarThrowsOutOfBoundsException() {
		final int testDistance = 7;

		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.UP))
				.isInstanceOf(OutOfBoundsException.class);
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.DOWN))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void lateralDirectionArgumentThrowsWrongDirectionException() {
		final int testDistance = 2;

		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.A))
				.isInstanceOf(WrongDirectionException.class);
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, testDistance, Direction.H))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, 2, Direction.UP_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, 2, Direction.UP_H))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, 2, Direction.DOWN_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> verticalTransformer.vertical(originCoordinate, 2, Direction.DOWN_H))
				.isInstanceOf(WrongDirectionException.class);
	}
}