package chessboard.models.pieces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.enums.Color;
import chessboard.models.places.Square;
import chessboard.services.helpers.Coordinate;

import static chessboard.services.helpers.IdTranslator.coordinateToId;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * pawn tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PawnTest {

	private static final Coordinate WHITE_START_COORDINATE = new Coordinate(3,1);
	private static final Coordinate Black_START_COORDINATE = new Coordinate(3,6);
	private static final int WHITE_START_ID = coordinateToId(WHITE_START_COORDINATE);
	private static final int BLACK_START_ID = coordinateToId(Black_START_COORDINATE);

	@Test
	public void whiteAdvanceOneToEmptySquareIsAllowed() throws Exception {
		Pawn pawn = new Pawn(false, false, WHITE_START_ID, Color.WHITE);
		Square destination = new Square(new Coordinate(3,2));

		assertThat(pawn.legalMove(destination)).isTrue();
	}

	@Test
	public void whiteAdvanceTwoToEmptySquareIsAllowedOnFirstTurn() throws Exception {
		Pawn pawn = new Pawn(false, false, WHITE_START_ID, Color.WHITE, true,false);
		Square destination = new Square(new Coordinate(3,3));

		assertThat(pawn.legalMove(destination)).isTrue();
	}

	@Test
	public void whiteCannotAdvanceTwoOnSubsequentMoves() throws Exception {
		Pawn pawn = new Pawn(false, false, WHITE_START_ID, Color.WHITE, false,false);
		Square destination = new Square(new Coordinate(3,3));

		assertThat(pawn.legalMove(destination)).isFalse();
	}
}