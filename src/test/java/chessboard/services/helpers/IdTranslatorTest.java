package chessboard.services.helpers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static chessboard.services.helpers.IdTranslator.coordinateToId;
import static chessboard.services.helpers.IdTranslator.idToCoordinate;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the square ID translator.
 *
 * @author David Hatton (dhatton@turnitin.com)
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class IdTranslatorTest {

	private static final int TEST_FILE_ID = 3;
	private static final int TEST_RANK_ID = 3;
	private static final int TEST_SQUARE_ID = 27;
	private static final Coordinate TEST_SQUARE_COORDINATE = new Coordinate(TEST_FILE_ID, TEST_RANK_ID);

	@Test
	public void idToCoordinateReturnsCorrectAnswer() throws Exception {
		assertThat(idToCoordinate(TEST_SQUARE_ID).getFileId()).isEqualTo(TEST_FILE_ID);
		assertThat(idToCoordinate(TEST_SQUARE_ID).getRankId()).isEqualTo(TEST_RANK_ID);
	}

	@Test
	public void coordinateToIdReturnsCorrectAnswer() throws Exception {
		assertThat(coordinateToId(TEST_SQUARE_COORDINATE)).isEqualTo(TEST_SQUARE_ID);
	}
}