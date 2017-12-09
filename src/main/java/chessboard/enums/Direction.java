package chessboard.enums;

/**
 * Directions on the chess board, both absolute and relative to player.
 *
 * @author David Hatton
 */
public enum Direction {

	/** Ahead relative to player */
	AHEAD("ahead"),

	/** Behind relative to player */
	BEHIND("behind"),

	/** Toward file A, the same for both players. */
	A("toward file A"),

	/** Toward file H, the same for both players. */
	H("toward file H"),

	/** Toward rank 7, the same for both players. */
	UP("toward rank 7"),

	/** Toward rank 0, the same for both players. */
	DOWN("toward rank 0");

	private String direction;

	Direction(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}
}
