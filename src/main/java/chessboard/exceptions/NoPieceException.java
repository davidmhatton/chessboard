package chessboard.exceptions;

import chessboard.models.pieces.Piece;
import chessboard.models.places.Square;

/**
 * Exception thrown when there is no piece on a square and there jolly well should be.
 *
 * @author David Hatton
 */
public class NoPieceException extends NullPointerException {

	private static final String DEFINITE_MESSAGE_TEMPLATE = "Expected to find a %s %s on square %d.";
	private static final String INDEFINITE_MESSAGE_TEMPLATE = "Expected to find a piece on square %d";
	private final Square targetSquare;
	private final Piece expectedPiece;

	/**
	 * For use when the identity of the missing piece is known.
	 *
	 * @param expectedPiece The piece that was expected
	 * @param targetSquare The square on which it was expected
	 */
	public NoPieceException(Piece expectedPiece, Square targetSquare) {
		super(String.format(
				DEFINITE_MESSAGE_TEMPLATE,
				expectedPiece.getName(),
				expectedPiece.getColor().getColor(),
				targetSquare.getId()
		));
		this.expectedPiece = expectedPiece;
		this.targetSquare = targetSquare;
	}


	/**
	 * For use when the identity of the missing piece is not known or not important.
	 *
	 * @param targetSquare The square on which a piece was expected
	 */
	public NoPieceException(Square targetSquare) {
		super(String.format(INDEFINITE_MESSAGE_TEMPLATE, targetSquare.getId()));
		this.targetSquare = targetSquare;
		this.expectedPiece = null;
	}

	public Piece getExpectedPiece() {
		return expectedPiece;
	}

	public Square getTargetSquare() {
		return targetSquare;
	}
}
