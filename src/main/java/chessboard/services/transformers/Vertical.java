package chessboard.services.transformers;

import chessboard.enums.Color;
import chessboard.enums.Direction;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.models.pieces.Piece;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

/**
 * Methods for vertical movement both relative and absolute.
 *
 * @author David Hatton
 */
public abstract class Vertical extends Transformer {

	public static Coordinate vertical(Coordinate coordinate, int distance, Direction direction)
			throws NoPieceException, OutOfBoundsException, WrongDirectionException {
		return vertical(coordinate, distance, direction, null);
	}

	public static Coordinate vertical(Coordinate coordinate, int distance, Direction direction, Piece piece)
			throws NoPieceException, OutOfBoundsException, WrongDirectionException {

		switch (direction) {
			case UP:
				return up(coordinate, distance);

			case DOWN:
				return up(coordinate, -distance);

			case AHEAD:
				if (piece != null) {
					if (piece.getColor() == Color.WHITE) {
						return up(coordinate, distance);
					} else {
						return up(coordinate, -distance);
					}
				} else {
					throw new NoPieceException(new Square(coordinate));
				}
				break;

			case BEHIND:
				if (piece != null) {
					if (piece.getColor() == Color.WHITE) {
						return up(coordinate, -distance);
					} else {
						return up(coordinate, distance);
					}
				} else {
					throw new NoPieceException(new Square(coordinate));
				}
				break;

			case H:
			case A:
				throw new WrongDirectionException(direction);
		}
	}

	private static Coordinate up(Coordinate coordinate, int distance) throws OutOfBoundsException {
		coordinate.setFileId(coordinate.getFileId() + distance);
		if (coordinateOutOfBounds(coordinate)) {
			throw new OutOfBoundsException(coordinate);
		} else {
			return coordinate;
		}
	}
}
