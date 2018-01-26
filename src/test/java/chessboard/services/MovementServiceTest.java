package chessboard.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import chessboard.enums.Direction;
import chessboard.services.helpers.Coordinate;
import chessboard.services.transformers.DiagonalTransformer;
import chessboard.services.transformers.KnightMoveTransformer;
import chessboard.services.transformers.LateralTransformer;
import chessboard.services.transformers.VerticalTransformer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test suite for movement service.
 *
 * @author David Hatton
 */
@RunWith(MockitoJUnitRunner.class)
public class MovementServiceTest {

	private static final Coordinate TEST_RETURN_COORDINATE = new Coordinate(1,1);
	private Coordinate origin;
	private int distance;

	private MovementService movementService;

	@Mock
	private DiagonalTransformer diagonalTransformer;

	@Mock
	private KnightMoveTransformer knightMoveTransformer;

	@Mock
	private LateralTransformer lateralTransformer;

	@Mock
	private VerticalTransformer verticalTransformer;

	@Before
	public void setUp() throws Exception {
		origin = new Coordinate(0,0);
		distance = 4;

		movementService = new MovementService(diagonalTransformer, knightMoveTransformer, lateralTransformer, verticalTransformer);

		when(diagonalTransformer.diagonal(any(Coordinate.class), anyInt(), any(Direction.class))).thenReturn(TEST_RETURN_COORDINATE);
		when(knightMoveTransformer.knightMove(any(Coordinate.class), anyListOf(Direction.class))).thenReturn(TEST_RETURN_COORDINATE);
		when(lateralTransformer.lateral(any(Coordinate.class), anyInt(), any(Direction.class))).thenReturn(TEST_RETURN_COORDINATE);
		when(verticalTransformer.vertical(any(Coordinate.class), anyInt(), any(Direction.class))).thenReturn(TEST_RETURN_COORDINATE);
	}

	@Test
	public void diagonalCallsDiagonalTransformerWithExpectedParams() throws Exception {
		final Direction direction = Direction.UP_H;

		movementService.diagonal(origin, distance, direction);
		verify(diagonalTransformer, times(1)).diagonal(origin, distance, direction);
	}

	@Test
	public void knightMoveCallsKnightMoveTransformerWithExpectedParams() throws Exception {
		final List<Direction> directionList = Arrays.asList(Direction.H, Direction.H, Direction.UP);

		movementService.knightMove(origin, directionList);
		verify(knightMoveTransformer, times(1)).knightMove(origin, directionList);
	}

	@Test
	public void lateralCallsLateralTransformerWithExpectedParams() throws Exception {
		final Direction direction = Direction.H;

		movementService.lateral(origin, distance, direction);
		verify(lateralTransformer, times(1)).lateral(origin, distance, direction);
	}

	@Test
	public void verticalCallsVerticalTransformerWithExpectedParams() throws Exception {
		final Direction direction = Direction.UP;

		movementService.vertical(origin, distance, direction);
		verify(verticalTransformer, times(1)).vertical(origin, distance, direction);
	}
}