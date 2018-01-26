package chessboard.services.transformers;

import chessboard.enums.Color;
import chessboard.enums.Direction;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.models.pieces.Piece;
import chessboard.models.places.Square;
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
		return vertical(coordinate, distance, direction, null);
	}

	public Coordinate vertical(Coordinate coordinate, int distance, Direction direction, Piece piece)
			throws NoPieceException, OutOfBoundsException, WrongDirectionException {

		Coordinate destinationCoordinate;

		if ((direction == Direction.AHEAD || direction == Direction.BEHIND) && piece == null) {
			throw new NoPieceException(new Square(coordinate));
		}

		switch (direction) {
			case UP:
				destinationCoordinate = up(coordinate, distance);
				break;
			case DOWN:
				destinationCoordinate = up(coordinate, -distance);
				break;
			case AHEAD:
				if (piece.getColor() == Color.WHITE) {
					destinationCoordinate = up(coordinate, distance);
				} else {
					destinationCoordinate = up(coordinate, -distance);
				}
				break;
			case BEHIND:
				if (piece.getColor() == Color.WHITE) {
					destinationCoordinate = up(coordinate, -distance);
				} else {
					destinationCoordinate = up(coordinate, distance);
				}
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
