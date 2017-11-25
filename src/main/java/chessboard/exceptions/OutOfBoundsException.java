package chessboard.exceptions;

/**
 * for when a returned square ID does not correspond to a board square.
 *
 * @author David Hatton
 */
public class OutOfBoundsException extends Exception {

	private static final String MESSAGE_TEMPLATE = "Id %d does not correspond to a square on the chessboard.";
	private final int id;

	public OutOfBoundsException(int id) {
		super(String.format(MESSAGE_TEMPLATE, id));
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
