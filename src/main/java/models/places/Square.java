package models.places;

import enums.Color;

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

	public Square(Integer file, Integer rank) {
		this.fileId = file;
		this.rankId = rank;
		this.id = (8 * rankId) + fileId;
		determineColor();
	}

	public Square(Integer id) {
		this.id = id;
		this.fileId = id % 8;
		this.rankId = (id - this.fileId) / 8;
	}

	private void determineColor() {
		if ((this.fileId % 2 == 1 && this.rankId % 2 == 0) || (this.fileId % 2 == 0 && this.rankId % 2 == 1)) {
			this.color = Color.WHITE;
		} else {
			this.color = Color.BLACK;
		}
	}

	public Integer getId() {
		return id;
	}

	public Integer getFileId() {
		return fileId;
	}

	public Integer getRankId() {
		return rankId;
	}

	public Color getColor() {
		return color;
	}
}
