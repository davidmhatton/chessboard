package chessboard.services.helpers;

import static chessboard.services.helpers.IdTranslator.coordinateToId;

/**
 * Coordinate object for use with squares.
 * The sole purpose of this object is to carry the coordinate information. No business logic here.
 *
 * @author David Hatton
 */
public class Coordinate {
	private int fileId;
	private int rankId;

	public Coordinate(int fileId, int rankId) {
		this.fileId = fileId;
		this.rankId = rankId;
	}

	public int getFileId() {
		return fileId;
	}

	public int getRankId() {
		return rankId;
	}

	@Override
	public int hashCode() {
		return coordinateToId(this);
	}

	@Override
	public boolean equals(Object obj) {

		final Coordinate objCoordinate = (Coordinate) obj;

		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		final boolean fileCheck = getFileId() == objCoordinate.getFileId();
		final boolean rankCheck = getRankId() == objCoordinate.getRankId();

		return fileCheck && rankCheck;
	}
}
