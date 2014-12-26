package de.oglimmer.dsa;

public interface Calculator {

	double getWinRate();

	static double round(double toRound) {
		return ((int) (toRound * 10000)) / 100d;
	}
}
