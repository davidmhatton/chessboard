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
	DOWN("toward rank 0"),

	/** diagonal toward A8, the same for both players. */
	UP_A("diagonal up and a-ward"),

	/** diagonal toward H8, the same for both players. */
	UP_H("diagonal up and h-ward"),

	/** diagonal toward A1, the same for both players. */
	DOWN_A("diagonal down and a-ward"),

	/** diagonal toward H1, the same for both players. */
	DOWN_H("diagonal down and h-ward");

	private String direction;

	Direction(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}
}
