package chessboard.models.pieces;

import chessboard.models.places.Square;

/**
 * Master piece.
 *
 * @author David Hatton
 */
public class Piece {

	private String name;
	private boolean taken;
	private boolean pinned;
	private Square location;

	public Piece() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}
}
