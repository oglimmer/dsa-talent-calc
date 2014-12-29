package de.oglimmer.dsa;

import lombok.Data;
import lombok.Getter;

public class WinRateCalculator {

	final private int[] attributeVal;
	final private int taw;
	final private int rollMax;

	private int fail;
	private int win;

	@Getter
	private double winRate;

	public WinRateCalculator(int[] attributeVal, int taw, int rollMax) {
		this.rollMax = rollMax;
		this.attributeVal = attributeVal;
		this.taw = taw;
		calc();
	}

	private void calc() {
		fail = 0;
		win = 0;
		Trial[] trials = Trial.fromAttrs(attributeVal);
		DieRollGenerator drg = new DieRollGenerator(trials, rollMax);
		for (int rollSeqNo = 1; rollSeqNo <= drg.getMaxRollSequenceNumber(); rollSeqNo++) {
			drg.setRollsToTrials(rollSeqNo);
			if (getTalentTest(trials).check()) {
				win++;
			} else {
				fail++;
			}
		}

		winRate = round(win / (fail + (double) win));
	}

	private TalentTest getTalentTest(Trial[] trials) {
		if (trials.length == 3) {
			return new DSATalentTest(trials, taw);
		} else {
			return new SimpleTalentTest(rollMax, trials, taw);
		}
	}

	private double round(double toRound) {
		return ((int) (toRound * 10000)) / 100d;
	}

}

/**
 * Given the number of dice and the max value for a dice, it generates all possible rolls for that dices.
 * 
 * @author oli
 */
@Data
class DieRollGenerator {

	private final Trial[] trials;
	private final int rollMax;

	long getMaxRollSequenceNumber() {
		return (long) Math.pow(rollMax, trials.length);
	}

	void setRollsToTrials(int rollSequenceNumber) {
		for (int dieNo = 0; dieNo < trials.length; dieNo++) {
			int dieValue = (int) ((((rollSequenceNumber - 1) / Math.pow(20, dieNo)) % 20) + 1);
			assert dieValue >= 1 && dieValue <= rollMax;
			trials[dieNo].roll(dieValue);
		}
	}
}
