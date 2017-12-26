package chessboard.services.transformers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.enums.Direction;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.models.pieces.Pawn;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.AbstractVerticalTransformer.vertical;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test suite for vertical motion.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AbstractVerticalTransformerTest {

	private Coordinate originCoordinate;

	@Before
	public void setUp() {
		originCoordinate = new Coordinate(3, 4);
	}

	@Test
	public void verticalWorksUp() throws Exception {
		final int testDistance = 2;
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.UP);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() + testDistance);
	}

	@Test
	public void verticalWorksDown() throws Exception {
		final int testDistance = 2;
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.DOWN);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() - testDistance);
	}

	@Test
	public void verticalWorksAheadForWhite() throws Exception {
		final int testDistance = 2;
		final Pawn testPiece = new Pawn(false, false, new Square(originCoordinate).getId(), Color.WHITE);
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.AHEAD, testPiece);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() + testDistance);
	}

	@Test
	public void verticalWorksAheadForBlack() throws Exception {
		final int testDistance = 2;
		final Pawn testPiece = new Pawn(false, false, new Square(originCoordinate).getId(), Color.BLACK);
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.AHEAD, testPiece);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() - testDistance);
	}

	@Test
	public void verticalWorksBehindForWhite() throws Exception {
		final int testDistance = 2;
		final Pawn testPiece = new Pawn(false, false, new Square(originCoordinate).getId(), Color.WHITE);
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.BEHIND, testPiece);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() - testDistance);
	}

	@Test
	public void verticalWorksBehindForBlack() throws Exception {
		final int testDistance = 2;
		final Pawn testPiece = new Pawn(false, false, new Square(originCoordinate).getId(), Color.BLACK);
		Coordinate destinationCoordinate = vertical(originCoordinate, testDistance, Direction.BEHIND, testPiece);

		assertThat(destinationCoordinate.getFileId()).isEqualTo(originCoordinate.getFileId());
		assertThat(destinationCoordinate.getRankId()).isEqualTo(originCoordinate.getRankId() + testDistance);
	}

	@Test
	public void aheadFromEmptySquareThrowsNoPieceException() {
		final int testDistance = 2;
		assertThatThrownBy(
				() -> vertical(originCoordinate, testDistance, Direction.AHEAD)
		).isInstanceOf(NoPieceException.class);
	}

	@Test
	public void behindFromEmptySquareThrowsNoPieceException() {
		final int testDistance = 2;
		assertThatThrownBy(
				() -> vertical(originCoordinate, testDistance, Direction.BEHIND)
		).isInstanceOf(NoPieceException.class);
	}

	@Test
	public void absoluteMoveTooFarThrowsOutOfBoundsException() {
		final int testDistance = 7;

		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.UP))
				.isInstanceOf(OutOfBoundsException.class);
		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.DOWN))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void relativeWhiteMoveTooFarThrowsOutOfBoundsException() {
		final int testDistance = 7;
		final Pawn testPieceWhite = new Pawn(false, false, new Square(originCoordinate).getId(), Color.WHITE);

		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.AHEAD, testPieceWhite))
				.isInstanceOf(OutOfBoundsException.class);
		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.BEHIND, testPieceWhite))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void relativeBlackMoveTooFarThrowsOutOfBoundsException() {
		final int testDistance = 7;
		final Pawn testPieceWhite = new Pawn(false, false, new Square(originCoordinate).getId(), Color.WHITE);

		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.AHEAD, testPieceWhite))
				.isInstanceOf(OutOfBoundsException.class);
		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.BEHIND, testPieceWhite))
				.isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void lateralDirectionArgumentThrowsWrongDirectionException() {
		final int testDistance = 2;

		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.A))
				.isInstanceOf(WrongDirectionException.class);
		assertThatThrownBy(() -> vertical(originCoordinate, testDistance, Direction.H))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> vertical(originCoordinate, 2, Direction.UP_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void upHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> vertical(originCoordinate, 2, Direction.UP_H))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downAThrowsWrongDirectionException() {
		assertThatThrownBy(() -> vertical(originCoordinate, 2, Direction.DOWN_A))
				.isInstanceOf(WrongDirectionException.class);
	}

	@Test
	public void downHThrowsWrongDirectionException() {
		assertThatThrownBy(() -> vertical(originCoordinate, 2, Direction.DOWN_H))
				.isInstanceOf(WrongDirectionException.class);
	}
}