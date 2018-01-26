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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service package for moving a piece.
 *
 * @author David Hatton
 */
@Service
public class MovementService {

	private Coordinate origin;

	@Autowired
	private DiagonalTransformer diagonalTransformer;

	@Autowired
	private KnightMoveTransformer knightMoveTransformer;

	@Autowired
	private LateralTransformer lateralTransformer;

	@Autowired
	private VerticalTransformer verticalTransformer;

	public MovementService() {
		// default constructor
	}

	public MovementService(Coordinate origin) {
		this.origin = origin;
	}

	public Coordinate diagonal(int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return diagonalTransformer.diagonal(origin, distance, direction);
	}

	public Coordinate knightMove(List<Direction> jumps) throws OutOfBoundsException, WrongDirectionException {
		return knightMoveTransformer.knightMove(origin, jumps);
	}

	public Coordinate lateral(int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return lateralTransformer.lateral(origin, distance, direction);
	}

	public Coordinate vertical(int distance, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		return verticalTransformer.vertical(origin, distance, direction);
	}
}
