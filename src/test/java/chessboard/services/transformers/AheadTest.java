package chessboard.services.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.exceptions.NoPieceException;
import chessboard.models.pieces.Pawn;
import chessboard.models.places.Square;

import static chessboard.services.transformers.Ahead.ahead;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test suite for ahead.
 *
 * @author David Hatton (dhatton@turnitin.com)
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AheadTest extends Transformer {

	private static final int ORIGIN = 27;

	@Test
	public void aheadDefinedForWhite() throws Exception {
		final Square square = new Square(27);
		final Pawn testPiece = new Pawn(false, false, ORIGIN, Color.WHITE);

		square.setPiece(testPiece);
		assertThat(ahead(square, 1)).isEqualTo(35);
	}

	@Test
	public void aheadDefinedForBlack() throws Exception {
		final Square square = new Square(27);
		final Pawn testPiece = new Pawn(false, false, ORIGIN, Color.BLACK);

		square.setPiece(testPiece);
		assertThat(ahead(square, 1)).isEqualTo(19);
	}

	@Test
	public void callOnEmptySquareThrowsNoPieceException(){
		final Square square = new Square(ORIGIN);
		assertThatThrownBy(() -> ahead(square, 1)).isInstanceOf(NoPieceException.class);
	}
}