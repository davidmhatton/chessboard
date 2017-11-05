package models.places;

/**
 * A vertical column of squares on a chessboard.
 *
 * @author David Hatton
 */
public class File {
	private boolean odd;
	private boolean even;
	private Integer id;

	public File(Integer id) {
		this.id = id;
		this.even = id % 2 == 1;
		this.odd = !this.even;
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
}
