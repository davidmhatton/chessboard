package models.places;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static assets.TestAssets.TEST_SQUARE_LIST;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class FileTest {

	@Test
	public void oddFileIsOdd() throws Exception {
		final int testId = 1;
		final File testFile = new File(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isOdd()).isTrue();
		assertThat(testFile.isEven()).isFalse();
	}

	@Test
	public void evenFileIsEven() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void zeroFileIsEven() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST);
		assertThat(testFile.isEven()).isTrue();
		assertThat(testFile.isOdd()).isFalse();
	}

	@Test
	public void fileContainsSquares() throws Exception {
		final int testId = 2;
		final File testFile = new File(testId, TEST_SQUARE_LIST);
		assertThat(testFile.getSquareList()).hasAtLeastOneElementOfType(Square.class);
	}
}