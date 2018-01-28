package chessboard.services.transformers;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import org.springframework.stereotype.Service;

/**
 * Transformers for diagonal movement.
 *
 * @author David Hatton
 */
@Service
public class DiagonalTransformer extends AbstractTransformer {

	private LateralTransformer lateralTransformer;
	private VerticalTransformer verticalTransformer;

	public DiagonalTransformer() {
		lateralTransformer = new LateralTransformer();
		verticalTransformer = new VerticalTransformer();
	}

	/**
	 * Master diagonal transformer.
	 *
	 * @param origin starting position
	 * @param distance the distance to travel
	 * @param direction the direction of travel
	 * @return Coordinate of destination
	 */
	public Coordinate diagonal(Coordinate origin, int distance, Direction direction) throws OutOfBoundsException {
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

	private Coordinate upA(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateralTransformer.lateral(origin, distance, Direction.A);
		destination = verticalTransformer.vertical(staging, distance, Direction.UP);

		return destination;
	}

	private Coordinate upH(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateralTransformer.lateral(origin, distance, Direction.H);
		destination = verticalTransformer.vertical(staging, distance, Direction.UP);

		return destination;
	}

	private Coordinate downA(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateralTransformer.lateral(origin, distance, Direction.A);
		destination = verticalTransformer.vertical(staging, distance, Direction.DOWN);

		return destination;
	}

	private Coordinate downH(Coordinate origin, int distance) throws OutOfBoundsException {
		Coordinate destination;
		Coordinate staging;

		staging = lateralTransformer.lateral(origin, distance, Direction.H);
		destination = verticalTransformer.vertical(staging, distance, Direction.DOWN);

		return destination;
	}
}
