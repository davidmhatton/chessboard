package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.services.helpers.Coordinate;

/**
 * Rook piece.
 *
 * @author David Hatton
 */
public class Rook extends Piece {

	public Rook(String name, String letter, boolean taken, boolean pinned, Coordinate location, Color color) {
		super(name, letter, taken, pinned, location, color);
	}
}
