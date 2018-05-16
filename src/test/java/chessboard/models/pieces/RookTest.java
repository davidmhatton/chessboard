package chessboard.models.pieces;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.enums.Piece;
import chessboard.services.helpers.Coordinate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Rook POJO test.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class RookTest {

	private static final Coordinate LOCATION = new Coordinate(2,3);
	private static final Color COLOR = Color.WHITE;

	private Rook testRook;

	@Before
	public void setUp() {
		testRook = new Rook(LOCATION, COLOR);
	}

	@Test
	public void rookConstructorSetsExpectedValues() {
		assertThat(testRook.getName()).isEqualTo(Piece.ROOK.getName());
		assertThat(testRook.getLetter()).isEqualTo(Piece.ROOK.getLetter());
		assertThat(testRook.isTaken()).isFalse();
		assertThat(testRook.isPinned()).isFalse();
		assertThat(testRook.getLocation()).isEqualTo(LOCATION);
		assertThat(testRook.getColor()).isEqualTo(COLOR);
	}
}