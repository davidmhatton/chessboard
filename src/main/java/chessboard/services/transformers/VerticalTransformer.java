package chessboard.services.transformers;

import chessboard.enums.Direction;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import org.springframework.stereotype.Service;

/**
 * Methods for vertical movement both relative and absolute.
 *
 * @author David Hatton
 */
@Service
public class VerticalTransformer extends AbstractTransformer {

	public Coordinate vertical(Coordinate coordinate, int distance, Direction direction)
			throws NoPieceException, OutOfBoundsException, WrongDirectionException {

		Coordinate destinationCoordinate;

		switch (direction) {
			case UP:
				destinationCoordinate = up(coordinate, distance);
				break;
			case DOWN:
				destinationCoordinate = up(coordinate, -distance);
				break;

			default:
				throw new WrongDirectionException(direction);
		}

		return destinationCoordinate;
	}

	private Coordinate up(Coordinate coordinate, int distance) throws OutOfBoundsException {
		Coordinate destinationCoordinate = new Coordinate(coordinate.getFileId(), coordinate.getRankId() + distance);

		if (coordinateOutOfBounds(destinationCoordinate)) {
			throw new OutOfBoundsException(destinationCoordinate);
		} else {
			return destinationCoordinate;
		}
	}
}
