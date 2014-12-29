package de.oglimmer.dsa;

import lombok.Data;

/**
 * Tests 1..n trials with taw given talent points on a rollMax sided dice.<br/>
 * <br/>
 * taw > 0: freely distributable talent points. one point can be used on one die roll only<br/>
 * taw < 0: value will be subtracted from each die roll<br/>
 * A (single) rollMax will always make the test fail<br/>
 * A 1 will always be a (single) success
 * 
 * @author oli
 */
@Data
public class SimpleTalentTest implements TalentTest {

	private final int rollMax;
	private final Trial[] trials;
	private final int taw;

	public boolean check() {
		int freeTaw = taw;
		boolean result = true;
		for (Trial trial : trials) {

			if (trial.getDieRoll() > 1
					&& (trial.getDieRoll() > trial.getAttributeValue() + freeTaw || trial.getDieRoll() == rollMax)) {
				result = false;
				freeTaw = 0;
			}

			if (trial.getDieRoll() > trial.getAttributeValue() && freeTaw > 0) {
				freeTaw -= trial.getDieRoll() - trial.getAttributeValue();
				assert freeTaw >= 0 : "taw < 0 (" + freeTaw + ")";
			}
		}
		return result;
	}

}