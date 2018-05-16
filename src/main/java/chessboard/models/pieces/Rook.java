package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.enums.Piece;
import chessboard.services.helpers.Coordinate;

/**
 * Rook piece.
 *
 * @author David Hatton
 */
public class Rook extends MasterPiece {

	public Rook(Coordinate location, Color color) {
		super(Piece.ROOK.getName(), Piece.ROOK.getLetter(), false, false, location, color);
	}
}
