package enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents colours.
 * Eventual plan to substitute word keys for colour codes when a front end requires it.
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
