package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.enums.Piece;
import chessboard.services.helpers.Coordinate;

public class Bishop extends MasterPiece {
	public Bishop(Coordinate location, Color color) {
		this.name = (Piece.BISHOP.getName());
		this.letter = (Piece.BISHOP.getLetter());
		this.taken = false;
		this.pinned = false;
		this.location = location;
		this.color = color;
	}
}
