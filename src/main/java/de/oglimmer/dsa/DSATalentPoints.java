package de.oglimmer.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;

public class DSATalentPoints {

	public static void main(String[] args) {
		new DSATalentPoints(convertToInts(args));
	}

	private static int[] convertToInts(String[] args) {
		List<Integer> intList = Arrays.asList(args).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		return ArrayUtils.toPrimitive(intList.toArray(new Integer[intList.size()]));
	}

	public DSATalentPoints(int[] talentVal) {

		for (int taw = -10; taw < 16; taw++) {
			TalentRollSuccessCalculator trsc = new TalentRollSuccessCalculator(talentVal, taw, 20);
			System.out.println("P(win) for TaW=" + taw + " == " + trsc.getWinRate() + "%");
		}

	}
}
