package models.places;

/**
 * A row of squares on a chessboard.
 *
 * @author David Hatton
 */
public class Rank {
	private boolean odd;
	private boolean even;
	private Integer id;

	public Rank(Integer id) {
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
