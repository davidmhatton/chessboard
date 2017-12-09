package chessboard.services.transformers;

import chessboard.exceptions.NoPieceException;
import chessboard.models.pieces.Piece;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

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

	static boolean coordinateOutOfBounds(Coordinate coordinate) {
		final boolean fileCheck = coordinate.getFileId() < 0 || coordinate.getFileId() > 7;
		final boolean rankCheck = coordinate.getRankId() < 0 || coordinate.getRankId() > 7;
		return fileCheck || rankCheck;
	}

	public static Piece findPiece(Square square) throws NoPieceException {
		try {
			return square.getPiece();
		} catch (NullPointerException npe) {
			throw new NoPieceException(square);
		}
	}
}
