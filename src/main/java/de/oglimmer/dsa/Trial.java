package de.oglimmer.dsa;

import lombok.Getter;
import lombok.ToString;

/**
 * Stands for a single trial, thus holds a die roll against an attribute value.
 * 
 * @author oli
 */
@ToString
public class Trial {

	public static Trial[] fromAttrs(int[] attrs) {
		Trial[] newlyCreatedTrials = new Trial[attrs.length];
		for (int i = 0; i < attrs.length; i++) {
			newlyCreatedTrials[i] = Trial.attr(attrs[i]);
		}
		return newlyCreatedTrials;
	}

	public static Trial attr(int attributeValue) {
		return new Trial(attributeValue);
	}

	@Getter
	private final int attributeValue;
	@Getter
	private int dieRoll;

	private Trial(int attributeValue) {
		this.attributeValue = attributeValue;
	}

	Trial roll(int dieRoll) {
		this.dieRoll = dieRoll;
		return this;
	}

}