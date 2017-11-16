package models.places;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import enums.Color;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test package for squares.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SquareTest {

	@Test
	public void evenSquareCreatesWithIdHasCoordinates() throws Exception {
		final Square evenSquare = new Square(16);

		assertThat(evenSquare.getFileId()).isEqualTo(0);
		assertThat(evenSquare.getRankId()).isEqualTo(2);
	}

	@Test
	public void oddSquareCreatesWithIdHasCoordinates() throws Exception {
		final Square oddSquare = new Square(17);

		assertThat(oddSquare.getFileId()).isEqualTo(1);
		assertThat(oddSquare.getRankId()).isEqualTo(2);
	}

	@Test
	public void evenSquareSecondRankCreatesWithIdHasCorrectColor() throws Exception {
		final Square evenSquare = new Square(16);
		assertThat(evenSquare.getColor()).isEqualTo(Color.BLACK);
	}

	@Test
	public void oddSquareSecondRankCreatesWithIdHasCorrectColor() throws Exception {
		final Square oddSquare = new Square(17);
		assertThat(oddSquare.getColor()).isEqualTo(Color.WHITE);
	}
}