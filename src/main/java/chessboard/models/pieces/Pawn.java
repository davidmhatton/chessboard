package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.helpers.IdTranslator.idToCoordinate;

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

	public Pawn(boolean taken, boolean pinned, int location, Color color) {
		super("Pawn", "P", taken, pinned, location, color);
		this.firstMove = true;
		setRange();
	}

	public Pawn(boolean taken, boolean pinned, int location, Color color, boolean firstMove, boolean enPassentReady) {
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
		final Coordinate location = idToCoordinate(getLocation());
		final int locationFileId = location.getFileId();
		final int locationRankId = location.getRankId();
		Piece destinationOccupiedBy = destination.getPiece();

		if (destination.getFileId() == locationFileId) {
			if (destinationOccupiedBy != null) {
				return false;
			}

			if (destination.getRankId() > locationRankId + getRange()) {
				return false;
			}
		}

		return true;
	}

	private boolean legalMoveBlack(Square destination) {
		// Temporary content to satisfy codacy
		return destination.equals(new Square(1));
	}
}
