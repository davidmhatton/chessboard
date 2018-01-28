package chessboard.services.transformers;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import org.springframework.stereotype.Service;

/**
 * Lateral movement methods.
 *
 * @author David Hatton
 */
@Service
public class LateralTransformer extends AbstractTransformer {

	/**
	 * Lateral transformer.
	 *
	 * @param coordinate coordinates that are to be transformed.
	 * @param givenDistance how far to move.
	 * @param direction the direction in which to move.
	 * @return coordinate of destination square.
	 */
	public Coordinate lateral(Coordinate coordinate, int givenDistance, Direction direction)
			throws OutOfBoundsException, WrongDirectionException {

		Coordinate destination = null;
		int distance;

		switch (direction) {
			case A:
				distance = -givenDistance;
				break;
			case H:
				distance = givenDistance;
				break;
			default:
				throw new WrongDirectionException(direction);
		}

		destination = new Coordinate(coordinate.getFileId() + distance, coordinate.getRankId());

		if (coordinateOutOfBounds(destination)) {
			throw new OutOfBoundsException(destination);
		} else {
			return destination;
		}
	}
}
