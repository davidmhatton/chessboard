package chessboard.services.transformers;

import chessboard.enums.Color;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.models.places.Square;

/**
 * Methods for finding a square ahead of a given square.
 *
 * @author David Hatton
 */
public abstract class Ahead extends Transformer {

	public static int ahead(Square origin, int distance) throws NoPieceException, OutOfBoundsException {
		int destination = -1;
		Color color;

		try	{
			color = origin.getPiece().getColor();
		} catch (NullPointerException npe) {
			throw new NoPieceException(origin);
		}

		switch (color) {
			case WHITE:
				destination = origin.getId() + (8 * distance);
				break;
			case BLACK:
				destination = origin.getId() - (8 * distance);
				break;
		}

		if (squareOutOfBounds(destination)) {
			throw new OutOfBoundsException(destination);
		}

		return destination;
	}

}
