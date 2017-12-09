package chessboard.services.transformers;


import chessboard.exceptions.OutOfBoundsException;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.helpers.IdTranslator.coordinateToId;

/**
 * Lateral movement methods.
 *
 * @author David Hatton
 */
public abstract class Lateral extends Transformer {

	private static Coordinate lateral(Square origin, int distance) {
		final Coordinate coordinate = new Coordinate(origin.getFileId(), origin.getRankId());
		coordinate.setFileId(coordinate.getFileId() - distance);

		return coordinate;

	}

	public static int lateralA(Square origin, int distance) throws OutOfBoundsException {
		Coordinate newCoordinate = lateral(origin, distance);

		if (coordinateOutOfBounds(newCoordinate)) {
			throw new OutOfBoundsException(newCoordinate);
		} else {
			return coordinateToId(newCoordinate);
		}
	}

	public static int lateralH(Square origin, int distance) throws OutOfBoundsException {
		Coordinate newCoordinate = lateral(origin, -distance);
		if (coordinateOutOfBounds(newCoordinate)) {
			throw new OutOfBoundsException(newCoordinate);
		} else {
			return coordinateToId(newCoordinate);
		}
	}
}
