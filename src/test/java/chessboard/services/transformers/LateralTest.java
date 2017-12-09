package chessboard.services.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.exceptions.OutOfBoundsException;
import chessboard.models.places.Square;

import static chessboard.services.transformers.Lateral.lateralA;
import static chessboard.services.transformers.Lateral.lateralH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Lateral movement tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class LateralTest {

	private static final Square ORIGIN = new Square(27);

	@Test
	public void lateralDefinedTowardA() throws Exception {
		assertThat(lateralA(ORIGIN, 2)).isEqualTo(25);
	}

	@Test
	public void lateralDefinedTowardH() throws Exception {
		assertThat(lateralH(ORIGIN, 2)).isEqualTo(29);
	}

	@Test
	public void tooFarTowardAThrowsOutOfBoundsException() {
		assertThatThrownBy(() -> lateralA(ORIGIN, 6)).isInstanceOf(OutOfBoundsException.class);
	}

	@Test
	public void tooFarTowardHThrowsOutOfBoundsException() {
		assertThatThrownBy(() -> lateralH(ORIGIN, 6)).isInstanceOf(OutOfBoundsException.class);
	}
}