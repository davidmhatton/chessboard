package chessboard.models.places;

import chessboard.enums.Color;
import chessboard.exceptions.NoPieceException;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.models.pieces.Piece;

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

	public Square(Integer file, Integer rank) {
		this.fileId = file;
		this.rankId = rank;
		this.id = (8 * rankId) + fileId;
		this.piece = null;
		determineColor();
	}

	public Square(Integer id) {
		this.id = id;
		this.fileId = id % 8;
		this.rankId = (id - this.fileId) / 8;
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

	private boolean idWithinBounds(int id) {
		return id >= 0 && id <= 63;
	}

	public int ahead(int distance) throws NoPieceException, OutOfBoundsException {
		int destination;
		switch (piece.getColor()) {
			case WHITE:
				destination = id + (8 * distance);
				break;
			case BLACK:
				destination = id - (8 * distance);
				break;

			default:
				throw new NoPieceException(this);
		}

		if (!idWithinBounds(destination)) {
			throw new OutOfBoundsException(destination);
		}

		return destination;
	}
}
