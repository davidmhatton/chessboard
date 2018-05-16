package chessboard.models.places;

import chessboard.enums.Color;
import chessboard.models.pieces.MasterPiece;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.helpers.IdTranslator.coordinateToId;
import static chessboard.services.helpers.IdTranslator.idToCoordinate;

/**
 * A square on a chess board.
 *
 * @author David Hatton
 */
public class Square {
	private Integer id;
	private Integer fileId;
	private Integer rankId;
	private Color color;
	private MasterPiece masterPiece;

	public Square(Coordinate coordinate) {
		this.fileId = coordinate.getFileId();
		this.rankId = coordinate.getRankId();
		this.id = coordinateToId(coordinate);
		this.masterPiece = null;
		determineColor();
	}

	public Square(Integer id) {
		final Coordinate coordinate = idToCoordinate(id);

		this.id = id;
		this.fileId = coordinate.getFileId();
		this.rankId = coordinate.getRankId();
		this.masterPiece = null;
		determineColor();
	}

	private void determineColor() {
		if ((this.fileId % 2 == 1 && this.rankId % 2 == 0) || (this.fileId % 2 == 0 && this.rankId % 2 == 1)) {
			this.color = Color.WHITE;
		} else {
			this.color = Color.BLACK;
		}
	}

	public int getId() {
		return id;
	}

	public int getFileId() {
		return fileId;
	}

	public int getRankId() {
		return rankId;
	}

	public Color getColor() {
		return color;
	}

	public MasterPiece getMasterPiece() {
		return masterPiece;
	}

	public void setMasterPiece(MasterPiece masterPiece) {
		this.masterPiece = masterPiece;
	}
}
