package chessboard.models.pieces;

import org.junit.Before;
import org.junit.Test;

import chessboard.enums.Color;
import chessboard.enums.Piece;
import chessboard.services.helpers.Coordinate;

import static org.assertj.core.api.Assertions.assertThat;

public class BishopTest {


	private static final Coordinate LOCATION = new Coordinate(2,3);
	private static final Color COLOR = Color.WHITE;

	private Bishop testBishop;

	@Before
	public void setUp() {
		testBishop = new Bishop(LOCATION, COLOR);
	}

	@Test
	public void bishopConstructorSetsExpectedValues() {
		assertThat(testBishop.getName()).isEqualTo(Piece.BISHOP.getName());
		assertThat(testBishop.getLetter()).isEqualTo(Piece.BISHOP.getLetter());
		assertThat(testBishop.isTaken()).isFalse();
		assertThat(testBishop.isPinned()).isFalse();
		assertThat(testBishop.getLocation()).isEqualTo(LOCATION);
		assertThat(testBishop.getColor()).isEqualTo(COLOR);
	}
}