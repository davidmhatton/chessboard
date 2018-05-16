package chessboard.enums;

/**
 * Description.
 *
 * @author David Hatton (dhatton@turnitin.com)
 */
public enum Piece {

	/** Name/letter pairing for a king. High value is a placeholder rather than a reflection of game rules.*/
	KING("King", "k", -1),

	/** Name/letter pairing for a queen. */
	QUEEN("Queen", "q", 9),

	/** Name/letter pairing for a rook. */
	ROOK("Rook", "r", 5),

	/** Name/letter pairing for a bishop. */
	BISHOP("Bishop", "b", 3),

	/** Name/letter pairing for a knight. */
	KNIGHT("Knight", "n", 3),

	/** Name/letter pairing for a pawn. */
	PAWN("Pawn", "p", 1);


	private String name;
	private String letter;
	private int value;

	Piece(String name, String letter, int value) {
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}

	public String getName() {
		return name;
	}
}
