package models.places;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import enums.Color;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for the board.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BoardTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void hasSixtyFoursquares() throws Exception {
		assertThat(board.getSquares().size()).isEqualTo(64);
	}

	@Test
	public void hasEightFiles() throws Exception {
		assertThat(board.getFiles().size()).isEqualTo(8);
	}

	@Test
	public void hasEightRanks() throws Exception {
		assertThat(board.getRanks().size()).isEqualTo(8);
	}

	@Test
	public void hasThirtyTwoBlackSquares() throws Exception {
		final List<Square> squareList = board.getSquares();
		final List<Square> blackSquareList = new ArrayList<>();

		squareList.forEach( (square) -> {
			if (square.getColor() == Color.BLACK) blackSquareList.add(square);
		});

		assertThat(blackSquareList.size()).isEqualTo(32);
	}

	@Test
	public void hasThirtyTwoWhiteSquares() throws Exception {
		final List<Square> squareList = board.getSquares();
		final List<Square> blackSquareList = new ArrayList<>();

		squareList.forEach( (square) -> {
			if (square.getColor() == Color.BLACK) blackSquareList.add(square);
		});

		assertThat(blackSquareList.size()).isEqualTo(32);
	}
}