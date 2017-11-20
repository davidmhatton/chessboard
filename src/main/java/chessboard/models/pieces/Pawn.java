package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.models.places.Square;

/**
 * A pawn.
 *
 * @author David Hatton
 */
public class Pawn extends Piece {

	private boolean firstMove;
	private boolean enPassentReady;

	public Pawn() {
		super();
	}

	public Pawn(boolean taken, boolean pinned, Square location, Color color) {
		super("Pawn", "P", taken, pinned, location, color);
		this.firstMove = true;
	}

	public Pawn(String name, String letter, boolean taken, boolean pinned, Square location, Color color, boolean firstMove, boolean enPassentReady) {
		super(name, letter, taken, pinned, location, color);
		this.firstMove = firstMove;
		this.enPassentReady = enPassentReady;
	}

	public boolean isFirstMove() {
		return firstMove;
	}

	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}

	public boolean isEnPassentReady() {
		return enPassentReady;
	}

	public void setEnPassentReady(boolean enPassentReady) {
		this.enPassentReady = enPassentReady;
	}

	public boolean legalMove(Square destination) {
		if (getColor() == Color.WHITE) {
			return legalMoveWhite(destination);
		} else {
			return legalMoveBlack(destination);
		}
	}

	private boolean legalMoveWhite(Square destination) {
		Piece destinationOccupiedBy = destination.getPiece();

		if (destination.getFileId() == getLocation().getFileId()) {
			if (destinationOccupiedBy != null) {
				return false;
			}
		}

		return true;
	}

	private boolean legalMoveBlack(Square destination) {
		return false;
	}
}
