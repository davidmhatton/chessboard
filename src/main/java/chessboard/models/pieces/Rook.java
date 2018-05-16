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
		this.name = (Piece.ROOK.getName());
		this.letter = (Piece.ROOK.getLetter());
		this.taken = false;
		this.pinned = false;
		this.location = location;
		this.color = color;
	}
}
