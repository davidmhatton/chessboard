package assets;

import java.util.ArrayList;
import java.util.Arrays;

import models.places.Square;

/**
 * Assets for use in tests.
 *
 * @author David Hatton
 */
public abstract class TestAssets {

	public static final ArrayList<Square> TEST_SQUARE_LIST = new ArrayList<>(
			Arrays.asList(
				new Square(0),
				new Square( 8),
				new Square(16),
				new Square(24),
				new Square(32),
				new Square(40),
				new Square(48),
				new Square(56)
			)
	);

}
