package chessboard.models.pieces;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.models.places.Square;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * pawn tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PawnTest {

	private static final Square TEST_START_POSITION_WHITE = new Square(3, 1);
//	private static final Square TEST_START_POSITION_BLACK = new Square(3,6);

	@Before
	public void setUp() {
	}

	@Test
	public void whiteAdvanceOneToEmptySquareIsAllowed() throws Exception {
		Pawn pawn = new Pawn(false, false, TEST_START_POSITION_WHITE, Color.WHITE);
		Square destination = new Square(3,2);

		assertThat(pawn.legalMove(destination)).isTrue();
	}

	@Test
	public void whiteAdvanceTwoToEmptySquareIsAllowedOnFirstTurn() throws Exception {
		Pawn pawn = new Pawn(false, false, TEST_START_POSITION_WHITE, Color.WHITE, true,false);
		Square destination = new Square(3,3);

		assertThat(pawn.legalMove(destination)).isTrue();
	}

	@Test
	public void whiteCannotAdvanceTwoOnSubsequentMoves() throws Exception {
		Pawn pawn = new Pawn(false, false, TEST_START_POSITION_WHITE, Color.WHITE, false,false);
		Square destination = new Square(3,3);

		assertThat(pawn.legalMove(destination)).isFalse();
	}
}