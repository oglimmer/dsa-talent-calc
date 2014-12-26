package de.oglimmer.dsa;

public class TalentRollSuccessCalculator {

	private Calculator calc;

	public TalentRollSuccessCalculator(int[] attributeVal, int taw, int rollMax) {
		if (taw > 0) {
			calc = new CountBasedCalc(attributeVal, taw, rollMax);
		} else {
			calc = new MathBasedCalc(attributeVal, taw, rollMax);
		}
	}

	public double getWinRate() {
		return calc.getWinRate();
	}

}
