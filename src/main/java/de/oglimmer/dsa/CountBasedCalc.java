package de.oglimmer.dsa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountBasedCalc implements Calculator {

	final private int[] attributeVal;
	final private int taw;
	final private int rollMax;

	private int fail;
	private int win;
	private double winRate;

	public CountBasedCalc(int[] attributeVal, int taw, int rollMax) {
		this.rollMax = rollMax;
		this.attributeVal = attributeVal;
		this.taw = taw;
		fail = 0;
		win = 0;
		assert taw > 0;
		calcForTalentPointsAvailable();
	}

	private void calcForTalentPointsAvailable() {
		for (int roll = 1; roll <= rollMax; roll++) {
			doAttrCalc(roll, taw, 0, Integer.toString(roll));
		}
		if (fail + win != Math.pow(rollMax, attributeVal.length)) {
			System.err.println("assert");
		}
		winRate = Calculator.round(win / (fail + (double) win));
	}

	private void doAttrCalc(int roll, int freeTaw, int levelNum, String debug) {
		AttributeCheck level = new AttributeCheck(roll, freeTaw, levelNum, debug);
		level.calc();
	}

	@Override
	public double getWinRate() {
		return winRate;
	}

	class AttributeCheck {

		final private int dieRoll;
		final private int freeTaw;
		final private int pos;

		final private String debug;

		public AttributeCheck(int dieRoll, int freeTaw, int pos, String debug) {
			this.dieRoll = dieRoll;
			this.freeTaw = freeTaw;
			this.pos = pos;
			this.debug = debug;
			assert freeTaw >= 0 : "freeTaw was " + freeTaw + " on " + debug;
		}

		public void calc() {
			if (isAttributeCheckSucceed()) {
				if (isLastAttr()) {
					win++;
					log.debug("win:{} ({})", debug, getFreeTawAfterThisAttr());
				} else {
					calcNextAttr();
				}
			} else {
				addFail();
			}
		}

		private boolean isAttributeCheckSucceed() {
			if (dieRoll == rollMax) {
				return false;
			}
			if (dieRoll <= attributeVal[pos] + freeTaw) {
				return true;
			}
			return false;
		}

		private void calcNextAttr() {
			nextAttr(getFreeTawAfterThisAttr());
		}

		private boolean rollHigherAttr() {
			return dieRoll > attributeVal[pos];
		}

		private boolean isLastAttr() {
			return pos >= attributeVal.length - 1;
		}

		private void nextAttr(int freeTawForNextAttr) {
			for (int dieRollOnNextAttr = 1; dieRollOnNextAttr <= rollMax; dieRollOnNextAttr++) {
				doAttrCalc(dieRollOnNextAttr, freeTawForNextAttr, pos + 1, debug + ":" + dieRollOnNextAttr);
			}
		}

		private int recalcFreeTaw() {
			return freeTaw - (dieRoll - attributeVal[pos]);
		}

		private int getFreeTawAfterThisAttr() {
			if (rollHigherAttr()) {
				return recalcFreeTaw();
			}
			return freeTaw;
		}

		private void addFail() {
			double addedFailScore = Math.pow(rollMax, attributeVal.length - pos - 1);
			fail += addedFailScore;
			log.debug("failed:{} (added:{})", debug, addedFailScore);
		}

	}

}
