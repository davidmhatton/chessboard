package chessboard.services.transformers;


import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.services.helpers.Coordinate;

/**
 * Lateral movement methods.
 *
 * @author David Hatton
 */
public abstract class Lateral extends Transformer {

	/**
	 * Lateral transformer.
	 *
	 * @param coordinate coordinates that are to be transformed.
	 * @param distance how far to move.
	 * @param direction the direction in which to move.
	 * @return coordinate of destination square.
	 */
	public static Coordinate lateral(Coordinate coordinate, int distance, Direction direction) throws OutOfBoundsException {
		if (direction == Direction.A) {
			distance = -distance;
		}
		coordinate.setFileId(coordinate.getFileId() + distance);

		if (coordinateOutOfBounds(coordinate)) {
			throw new OutOfBoundsException(coordinate);
		} else {
			return coordinate;
		}
	}
}
