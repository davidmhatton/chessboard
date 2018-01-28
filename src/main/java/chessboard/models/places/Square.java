package chessboard.models.places;

import chessboard.enums.Color;
import chessboard.models.pieces.Piece;
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
	private Piece piece;

	public Square(Coordinate coordinate) {
		this.fileId = coordinate.getFileId();
		this.rankId = coordinate.getRankId();
		this.id = coordinateToId(coordinate);
		this.piece = null;
		determineColor();
	}

	public Square(Integer id) {
		final Coordinate coordinate = idToCoordinate(id);

		this.id = id;
		this.fileId = coordinate.getFileId();
		this.rankId = coordinate.getRankId();
		this.piece = null;
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

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
