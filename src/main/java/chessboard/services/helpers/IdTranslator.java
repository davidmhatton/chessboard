package chessboard.services.helpers;

/**
 * Transformers for the ID of a square to rank/file coordinates and vice-versa.
 *
 * @author David Hatton
 */
public abstract class IdTranslator {

	public static int coordinateToId(Coordinate coordinate) {
		return (8 * coordinate.getRankId()) + coordinate.getFileId();
	}

	public static Coordinate idToCoordinate(int id) {
		int fileId = id % 8;
		int rankId = (id - fileId) / 8;
		return new Coordinate(fileId, rankId);
	}
}
