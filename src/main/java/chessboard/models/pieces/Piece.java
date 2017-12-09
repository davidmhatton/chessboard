package chessboard.models.pieces;

import chessboard.enums.Color;

/**
 * Master piece.
 *
 * @author David Hatton
 */
public class Piece {

	private String name;
	private String letter;
	private boolean taken;
	private boolean pinned;
	private int location;
	private Color color;

	public Piece() {
	}

	public Piece(String name, String letter, boolean taken, boolean pinned, int location, Color color) {
		this.name = name;
		this.letter = letter;
		this.taken = taken;
		this.pinned = pinned;
		this.location = location;
		this.color = color;
	}

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

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}
}
