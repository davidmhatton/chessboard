package chessboard.services.transformers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import chessboard.models.places.Square;

import static chessboard.services.transformers.Lateral.lateralA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Lateral movement tests.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class LateralTest {

	@Test
	public void lateralDefinedTowardA() throws Exception {
		final Square origin = new Square(27);
		assertThat(lateralA(origin, 2)).isEqualTo(25);
	}
}