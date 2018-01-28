package chessboard.exceptions;

import chessboard.enums.Direction;

/**
 * For use when someone passes the wrong direction.
 *
 * @author David Hatton
 */
public class WrongDirectionException extends IllegalArgumentException {

	private final Direction direction;

	private static final String MESSAGE_TEMPLATE = "Invalid direction passed: %s.";

	public WrongDirectionException(Direction direction) {
		super(String.format(MESSAGE_TEMPLATE, direction.getDirection()));
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public static String getMessageTemplate() {
		return MESSAGE_TEMPLATE;
	}
}
