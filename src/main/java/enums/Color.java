package enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Description.
 *
 * @author David Hatton
 */
public enum Color {

	/**
	 * represents white.
	 */
	WHITE("white"),

	/**
	 * represents black.
	 */
	BLACK("black");

	private String color;

	Color(String color) {
		this.color = color;
	}

	@JsonValue
	public String getColor() {
		return color;
	}
}
