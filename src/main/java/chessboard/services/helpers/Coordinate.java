package chessboard.services.helpers;

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

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
}
