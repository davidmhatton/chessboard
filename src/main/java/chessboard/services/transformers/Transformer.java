package chessboard.services.transformers;

/**
 * Master Transformer.
 *
 * @author David Hatton
 */
public abstract class Transformer {

	public static boolean squareWithinBounds(int id) {
		return id >= 0 && id <= 63;
	}

	public static boolean squareOutOfBounds(int id) {
		return !squareWithinBounds(id);
	}
}
