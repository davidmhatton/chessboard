package chessboard.services.transformers;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.transformers.AbstractLateralTransformer.lateral;
import static chessboard.services.transformers.AbstractVerticalTransformer.vertical;

/**
 * Transformers for diagonal movement.
 *
 * @author David Hatton
 */
public abstract class AbstractDiagonalTransformer extends AbstractTransformer {

	/**
	 * Master diagonal transformer.
	 *
	 * @param origin starting position
	 * @param distance the distance to travel
	 * @param direction the direction of travel
	 * @return Coordinate of destination
	 */
	public static Coordinate diagonal(Coordinate origin, int distance, Direction direction) throws OutOfBoundsException {
		Coordinate destination;
		switch (direction) {
			case UP_A:
				destination = upA(origin, distance);
				break;
			case UP_H:
				destination = upH(origin, distance);
				break;
			case DOWN_A:
				destination = downA(origin, distance);
				break;
			case DOWN_H:
				destination = downH(origin, distance);
				break;

			default:
				throw new WrongDirectionException(direction);
		}

		return destination;
	}

	private static Coordinate upA(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateral(origin, distance, Direction.A);
		destination = vertical(staging, distance, Direction.UP);

		return destination;
	}

	private static Coordinate upH(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateral(origin, distance, Direction.H);
		destination = vertical(staging, distance, Direction.UP);

		return destination;
	}

	private static Coordinate downA(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateral(origin, distance, Direction.A);
		destination = vertical(staging, distance, Direction.DOWN);

		return destination;
	}

	private static Coordinate downH(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateral(origin, distance, Direction.H);
		destination = vertical(staging, distance, Direction.DOWN);

		return destination;
	}
}
