package de.oglimmer.dsa;

public class MathBasedCalc implements Calculator {

	final private int[] attributeVal;
	final private int taw;
	final private int rollMax;

	private double winRate;

	public MathBasedCalc(int[] attributeVal, int taw, int rollMax) {
		this.rollMax = rollMax;
		this.attributeVal = attributeVal;
		this.taw = taw;
		assert taw <= 0;
		noTalentPoints();
	}

	private void noTalentPoints() {
		winRate = 1;
		for (int i = 0; i < attributeVal.length; i++) {
			winRate *= (Math.max(1, attributeVal[i] + taw)) / (double) rollMax;
		}
		winRate = Calculator.round(winRate);
	}

	@Override
	public double getWinRate() {
		return winRate;
	}

}
