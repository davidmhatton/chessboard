package chessboard.exceptions;

import chessboard.services.helpers.Coordinate;

import static chessboard.services.helpers.IdTranslator.coordinateToId;
import static chessboard.services.helpers.IdTranslator.idToCoordinate;

/**
 * for when a returned square ID does not correspond to a board square.
 *
 * @author David Hatton
 */
public class OutOfBoundsException extends Exception {

	private static final String MESSAGE_TEMPLATE = "Id %d does not correspond to a square on the chessboard.";
	private static final String COORDINATE_MESSAGE_TEMPLATE = "coordinates %d, %d do not correspond to a valid square.";
	private final int id;
	private final Coordinate coordinate;

	public OutOfBoundsException(int id) {
		super(String.format(MESSAGE_TEMPLATE, id));
		this.id = id;
		this.coordinate = idToCoordinate(id);
	}

	public OutOfBoundsException(Coordinate coordinate) {
		super(String.format(COORDINATE_MESSAGE_TEMPLATE, coordinate.getFileId(), coordinate.getRankId()));
		this.id = coordinateToId(coordinate);
		this.coordinate = idToCoordinate(id);
	}



	public int getId() {
		return id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
}
