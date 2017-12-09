package chessboard.services.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.exceptions.NoPieceException;
import chessboard.models.pieces.Pawn;
import chessboard.models.places.Square;

import static chessboard.services.transformers.Behind.behind;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Test package for Behind.
 *
 * @author David Hatton (dhatton@turnitin.com)
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BehindTest {
	@Test
	public void behindDefinedForWhite() throws Exception {
		final Square square = new Square(27);
		final int originId = 27;
		final Pawn testPiece = new Pawn(false, false, originId, Color.WHITE);

		square.setPiece(testPiece);
		assertThat(behind(square, 1)).isEqualTo(19);
	}

	@Test
	public void behindDefinedForBlack() throws Exception {
		final Square square = new Square(27);
		final int originId = 27;
		final Pawn testPiece = new Pawn(false, false, originId, Color.BLACK);

		square.setPiece(testPiece);
		assertThat(behind(square, 1)).isEqualTo(35);
	}

	@Test
	public void callOnEmptySquareThrowsNoPieceException() {
		final Square square = new Square(27);
		assertThatThrownBy(() -> behind(square, 1)).isInstanceOf(NoPieceException.class);
	}
}