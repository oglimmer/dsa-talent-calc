package de.oglimmer.dsa;

import lombok.Data;

/**
 * Tests 3 trials with taw given talent points on a 20-sided dice.<br/>
 * <br/>
 * taw > 0: freely distributable talent points. one point can be used on one die roll only<br/>
 * taw < 0: value will be subtracted from each die roll<br/>
 * Second 1: will make the talent check succeeded<br/>
 * Second 20: will make the talent check failed (even if taw points left)
 * 
 * @author oli
 */
@Data
public class DSATalentTest implements TalentTest {

	private final Trial[] trials;
	private final int taw;

	public boolean check() {
		assert trials.length == 3;
		int freeTaw = taw;
		boolean scoredOne = false;
		boolean scoredTwenty = false;
		boolean result = true;
		for (Trial trial : trials) {
			if (trial.getDieRoll() == 1 && scoredOne) {
				return true;
			}
			if (trial.getDieRoll() == 20 && scoredTwenty) {
				return false;
			}
			if (trial.getDieRoll() > trial.getAttributeValue() + freeTaw) {
				result = false;
				freeTaw = 0;
			}
			if (trial.getDieRoll() == 1) {
				scoredOne = true;
			}
			if (trial.getDieRoll() == 20) {
				scoredTwenty = true;
			}
			if (trial.getDieRoll() > trial.getAttributeValue() && freeTaw > 0) {
				freeTaw -= (trial.getDieRoll() - trial.getAttributeValue());
				assert freeTaw >= 0 : "taw < 0 (" + freeTaw + ")";
			}
		}
		return result;
	}

}