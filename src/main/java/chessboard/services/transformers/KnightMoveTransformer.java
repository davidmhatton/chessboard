package chessboard.services.transformers;

import java.util.List;

import chessboard.enums.Direction;
import chessboard.exceptions.OutOfBoundsException;
import chessboard.exceptions.WrongDirectionException;
import chessboard.services.helpers.Coordinate;

import org.springframework.stereotype.Service;

/**
 * Knight move transformer package.
 *
 * @author David Hatton
 */
@Service
public class KnightMoveTransformer extends AbstractTransformer {

	private LateralTransformer lateralTransformer;
	private VerticalTransformer verticalTransformer;

	public KnightMoveTransformer() {
		lateralTransformer = new LateralTransformer();
		verticalTransformer = new VerticalTransformer();
	}

	/**
	 * Knight move transformer.
	 *
	 * @param origin starting coordinate
	 * @param jumps  list of three directions for movement.
	 * @return destination coordinate
	 * @throws OutOfBoundsException    when the destination is off-board.
	 * @throws WrongDirectionException when a direction other than {up, down, A, H} is provided in jumps.
	 */
	public Coordinate knightMove(Coordinate origin, List<Direction> jumps) throws OutOfBoundsException, WrongDirectionException {

		Coordinate staging1 = knightStage(origin, jumps.get(0));
		Coordinate staging2 = knightStage(staging1, jumps.get(1));

		return knightStage(staging2, jumps.get(2));
	}

	private Coordinate knightStage(Coordinate previous, Direction direction) throws OutOfBoundsException, WrongDirectionException {
		Coordinate next;
		switch (direction) {
			case UP:
			case DOWN:
				next = verticalTransformer.vertical(previous, 1, direction);
				break;
			case A:
			case H:
				next = lateralTransformer.lateral(previous, 1, direction);
				break;
			default:
				throw new WrongDirectionException(direction);
		}

		return next;
	}

}
