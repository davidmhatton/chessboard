package chessboard.models.pieces;

import net.codebox.javabeantester.JavaBeanTester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Test for base piece class.
 *
 * @author David Hatton
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PieceTest {

	@Test
	public void beanTest() throws Exception {
		JavaBeanTester.test(Piece.class);
	}
}