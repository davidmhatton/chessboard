package chessboard.models.pieces;

import chessboard.enums.Color;
import chessboard.services.helpers.Coordinate;

/**
 * Master piece.
 *
 * @author David Hatton
 */
public abstract class MasterPiece {

	String name;
	String letter;
	boolean taken;
	boolean pinned;
	Coordinate location;
	Color color;

	public String getName() {
		return name;
	}

	public String getLetter() {
		return letter;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}
}
