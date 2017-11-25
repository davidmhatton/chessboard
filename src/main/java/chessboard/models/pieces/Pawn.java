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
	private int range;

	public Pawn() {
		super();
	}

	public Pawn(boolean taken, boolean pinned, Square location, Color color) {
		super("Pawn", "P", taken, pinned, location, color);
		this.firstMove = true;
		setRange();
	}

	public Pawn(boolean taken, boolean pinned, Square location, Color color, boolean firstMove, boolean enPassentReady) {
		super("Pawn", "P", taken, pinned, location, color);
		this.firstMove = firstMove;
		this.enPassentReady = enPassentReady;
		setRange();
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

	public int getRange() {
		return range;
	}

	public void setRange() {
		this.range = isFirstMove() ? 2 : 1;
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

			if (destination.getRankId() > getLocation().getRankId() + getRange()) {
				return false;
			}
		}

		return true;
	}

	private boolean legalMoveBlack(Square destination) {
		return false;
	}
}
