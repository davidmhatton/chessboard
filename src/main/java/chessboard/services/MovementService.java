package chessboard.services;

import java.util.List;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;
import chessboard.services.transformers.DiagonalTransformer;
import chessboard.services.transformers.KnightMoveTransformer;
import chessboard.services.transformers.LateralTransformer;
import chessboard.services.transformers.VerticalTransformer;

import org.springframework.stereotype.Service;

/**
 * Service package for moving a piece.
 *
 * @author David Hatton
 */
@Service
public class MovementService {

	private DiagonalTransformer diagonalTransformer;
	private KnightMoveTransformer knightMoveTransformer;
	private LateralTransformer lateralTransformer;
	private VerticalTransformer verticalTransformer;

	public MovementService(DiagonalTransformer diagonalTransformer, KnightMoveTransformer knightMoveTransformer, LateralTransformer lateralTransformer, VerticalTransformer verticalTransformer) {
		this.diagonalTransformer = diagonalTransformer;
		this.knightMoveTransformer = knightMoveTransformer;
		this.lateralTransformer = lateralTransformer;
		this.verticalTransformer = verticalTransformer;
	}

	public Coordinate diagonal(Coordinate origin, int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return diagonalTransformer.diagonal(origin, distance, direction);
	}

	public Coordinate knightMove(Coordinate origin, List<Direction> jumps) throws OutOfBoundsException, WrongDirectionException {
		return knightMoveTransformer.knightMove(origin, jumps);
	}

	public Coordinate lateral(Coordinate origin, int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return lateralTransformer.lateral(origin, distance, direction);
	}

	public Coordinate vertical(Coordinate origin, int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return verticalTransformer.vertical(origin, distance, direction);
	}
}
