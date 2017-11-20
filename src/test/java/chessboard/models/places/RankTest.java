package chessboard.models.places;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;

import static assets.TestAssets.TEST_SQUARE_LIST_RANK;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class RankTest {

	@Test
	public void oddRankIsOdd() throws Exception {
		final int testId = 1;
		final Rank testRank = new Rank(testId, TEST_SQUARE_LIST_RANK);
		assertThat(testRank.isOdd()).isTrue();
		assertThat(testRank.isEven()).isFalse();
	}

	@Test
	public void evenRankIsEven() throws Exception {
		final int testId = 2;
		final Rank testRank = new Rank(testId, TEST_SQUARE_LIST_RANK);
		assertThat(testRank.isEven()).isTrue();
		assertThat(testRank.isOdd()).isFalse();
	}

	@Test
	public void zeroRankIsEven() throws Exception {
		final int testId = 2;
		final Rank testRank = new Rank(testId, TEST_SQUARE_LIST_RANK);
		assertThat(testRank.isEven()).isTrue();
		assertThat(testRank.isOdd()).isFalse();
	}

	@Test
	public void rankContainsSquares() throws Exception {
		final int testId = 2;
		final Rank testRank = new Rank(testId, TEST_SQUARE_LIST_RANK);
		assertThat(testRank.getSquareList()).hasAtLeastOneElementOfType(Square.class);
	}

	@Test
	public void rankContainsFourWhiteSquares() throws Exception {
		final Rank testRank = new Rank(0, TEST_SQUARE_LIST_RANK);
		int whiteSquares = 0;

		for (Square square: testRank.getSquareList()) {
			if (square.getColor() == Color.WHITE) whiteSquares++;
		}

		assertThat(whiteSquares).isEqualTo(4);
	}

	@Test
	public void rankContainsFourBlackSquares() throws Exception {
		final Rank testRank = new Rank(0, TEST_SQUARE_LIST_RANK);
		int blackSquares = 0;

		for (Square square: testRank.getSquareList()) {
			if (square.getColor() == Color.BLACK) blackSquares++;
		}

		assertThat(blackSquares).isEqualTo(4);
	}

}