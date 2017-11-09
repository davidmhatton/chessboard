package models.places;

import java.util.ArrayList;
import java.util.List;

/**
 * A vertical column of squares on a chessboard.
 *
 * @author David Hatton
 */
public class File {
	private boolean odd;
	private boolean even;
	private Integer id;
	private List<Square> squareList;

	public File(Integer id) {
		this.id = id;
		this.even = id % 2 == 0;
		this.odd = !this.even;
		this.squareList = new ArrayList<>();
		for (int i = 0; i < 8; i++) this.squareList.add(new Square(id, i));
	}

	public boolean isOdd() {
		return odd;
	}

	public boolean isEven() {
		return even;
	}

	public Integer getId() {
		return id;
	}

	public List<Square> getSquareList() {
		return squareList;
	}
}
