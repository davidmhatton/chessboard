package chessboard.services.transformers;

import chessboard.exceptions.NoPieceException;
import chessboard.models.pieces.Piece;
import chessboard.models.places.Square;

/**
 * Master Transformer.
 *
 * @author David Hatton
 */
public abstract class Transformer {

	private static boolean squareWithinBounds(int id) {
		return id >= 0 && id <= 63;
	}

	static boolean squareOutOfBounds(int id) {
		return !squareWithinBounds(id);
	}

	public static Piece findPiece(Square square) throws NoPieceException {
		try {
			return square.getPiece();
		} catch (NullPointerException npe) {
			throw new NoPieceException(square);
		}
	}
}
