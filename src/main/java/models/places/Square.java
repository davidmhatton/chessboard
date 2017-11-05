package models.places;

import enums.Color;

/**
 * A square on a chess board.
 *
 * @author David Hatton
 */
public class Square {
	private Integer id;
	private File file;
	private Rank rank;
	private Color color;

	public Square(File file, Rank rank) {
		this.file = file;
		this.rank = rank;
		this.id = (8 * rank.getId()) + file.getId();
		determineColor();
	}
//	z = 8y + x
//	z

	public Square(Integer id) {
		this.id = id;

	}

	private void determineColor() {
		if ((this.file.isOdd() && this.rank.isEven()) || (this.file.isEven() && this.rank.isOdd())) {
			this.color = Color.WHITE;
		} else {
			this.color = Color.BLACK;
		}
	}

	public Integer getId() {
		return id;
	}

	public File getFile() {
		return file;
	}

	public Rank getRank() {
		return rank;
	}

	public Color getColor() {
		return color;
	}
}
