package models.places;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static assets.TestAssets.TEST_SQUARE_LIST;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class RankTest {

	@Test
	public void oddRankIsOdd() throws Exception {
		final int testId = 1;
		final Rank testFile = new Rank(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isOdd()).isTrue();
		assertThat(testFile.isEven()).isFalse();
	}

	@Test
	public void evenRankIsEven() throws Exception {
		final int testId = 2;
		final Rank testFile = new Rank(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void zeroRankIsEven() throws Exception {
		final int testId = 2;
		final Rank testFile = new Rank(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void rankContainsSquares() throws Exception {
		final int testId = 2;
		final Rank testFile = new Rank(testId, TEST_SQUARE_LIST);
		assertThat(testFile.getSquareList()).hasAtLeastOneElementOfType(Square.class);
	}


}