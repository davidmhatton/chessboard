package models.places;

import java.util.Arrays;
import java.util.List;

import models.pieces.Piece;

/**
 * The board as a whole.
 *
 * @author David Hatton
 */
public class Board {
	private List<Rank> ranks;
	private List<File> files;
	private List<Square> squares;
	private List<Piece> pieces;

	public Board() {
		for (int i = 0; i < 8; i++) {
			this.ranks.add(new Rank(i));
			this.files.add(new File(i));

		}
	}
}
