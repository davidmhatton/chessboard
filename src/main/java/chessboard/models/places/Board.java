package chessboard.models.places;

import java.util.ArrayList;
import java.util.List;

import chessboard.models.pieces.MasterPiece;

/**
 * The board as a whole.
 *
 * @author David Hatton
 */
public class Board {
	private List<Rank> ranks;
	private List<File> files;
	private List<Square> squares;
	private List<MasterPiece> masterPieces;

	public Board() {
		this.squares = new ArrayList<>();
		for (int i = 0; i < 64; i++) {
			this.squares.add(new Square(i));
		}
		this.files = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			this.files.add(new File(i, populateFileSquares(i)));
		}
		this.ranks = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			this.ranks.add(new Rank(i, populateRankSquares(i)));
		}
	}

	private List<Square> populateFileSquares(Integer fileId) {
		final ArrayList<Square> fileSquares = new ArrayList<>();
		for (int y = 0; y < 8; y++) {
			fileSquares.add(squares.get(fileId + (8 * y)));
		}
		return fileSquares;
	}

	private List<Square> populateRankSquares(Integer rankId) {
		final ArrayList<Square> rankSquares = new ArrayList<>();
		for (int x = 0; x < 8; x++) {
			rankSquares.add(squares.get(rankId + x));
		}
		return rankSquares;
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	public List<File> getFiles() {
		return files;
	}

	public List<Square> getSquares() {
		return squares;
	}

	public List<MasterPiece> getMasterPieces() {
		return masterPieces;
	}
}
