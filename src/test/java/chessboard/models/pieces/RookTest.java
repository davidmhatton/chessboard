package chessboard.models.pieces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import net.codebox.javabeantester.JavaBeanTester;

/**
 * Rook POJO test.
 *
 * @author David Hatton (dhatton@turnitin.com)
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class RookTest {

	@Test
	public void beanTest() throws Exception {
		JavaBeanTester.test(Rook.class);
	}
}