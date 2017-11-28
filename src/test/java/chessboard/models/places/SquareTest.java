package chessboard.models.places;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.models.pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test package for squares.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SquareTest {

	@Test
	public void evenSquareCreatesWithIdHasCoordinates() throws Exception {
		final Square evenSquare = new Square(16);

		assertThat(evenSquare.getFileId()).isEqualTo(0);
		assertThat(evenSquare.getRankId()).isEqualTo(2);
	}

	@Test
	public void oddSquareCreatesWithIdHasCoordinates() throws Exception {
		final Square oddSquare = new Square(17);

		assertThat(oddSquare.getFileId()).isEqualTo(1);
		assertThat(oddSquare.getRankId()).isEqualTo(2);
	}

	@Test
	public void evenSquareSecondRankCreatesWithIdHasCorrectColor() throws Exception {
		final Square evenSquare = new Square(16);
		assertThat(evenSquare.getColor()).isEqualTo(Color.BLACK);
	}

	@Test
	public void oddSquareSecondRankCreatesWithIdHasCorrectColor() throws Exception {
		final Square oddSquare = new Square(17);
		assertThat(oddSquare.getColor()).isEqualTo(Color.WHITE);
	}

	@Test
	public void aheadDefinedForWhite() throws Exception {
		final Square square = new Square(27);
		final Pawn testPiece = new Pawn(false, false, square, Color.WHITE);

		square.setPiece(testPiece);
		assertThat(square.ahead(1)).isEqualTo(35);
	}

	@Test
	public void aheadDefinedForBlack() throws Exception {
		final Square square = new Square(27);
		final Pawn testPiece = new Pawn(false, false, square, Color.BLACK);

		square.setPiece(testPiece);
		assertThat(square.ahead(1)).isEqualTo(19);
	}
}