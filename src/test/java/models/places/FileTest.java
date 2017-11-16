package models.places;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import enums.Color;

import static assets.TestAssets.TEST_SQUARE_LIST_FILE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class FileTest {

	@Test
	public void oddFileIsOdd() throws Exception {
		final int testId = 1;
		final File testFile = new File(testId, TEST_SQUARE_LIST_FILE);
		assertThat(testFile.isOdd()).isTrue();
		assertThat(testFile.isEven()).isFalse();
	}

	@Test
	public void evenFileIsEven() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST_FILE);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void zeroFileIsEven() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST_FILE);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void fileContainsSquares() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST_FILE);
		assertThat(testFile.getSquareList()).hasAtLeastOneElementOfType(Square.class);
	}

	@Test
	public void rankContainsFourWhiteSquares() throws Exception {
		final Rank testFile = new Rank(0, TEST_SQUARE_LIST_FILE);
		int whiteSquares = 0;

		for (Square square: testFile.getSquareList()) {
			if (square.getColor() == Color.WHITE) whiteSquares++;
		}

		assertThat(whiteSquares).isEqualTo(4);
	}

	@Test
	public void rankContainsFourBlackSquares() throws Exception {
		final Rank testFile = new Rank(0, TEST_SQUARE_LIST_FILE);
		int blackSquares = 0;

		for (Square square: testFile.getSquareList()) {
			if (square.getColor() == Color.BLACK) blackSquares++;
		}

		assertThat(blackSquares).isEqualTo(4);
	}
}