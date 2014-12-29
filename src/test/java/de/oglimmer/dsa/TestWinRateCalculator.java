package de.oglimmer.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class TestWinRateCalculator {

	@Test
	public void testCalc1() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 10 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc2() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 5 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc3() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 15 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc11() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 9 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc21() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 4 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc31() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 14 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc111() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 8 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc211() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 3 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc311() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 13 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc4() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 20 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalc41() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 20 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalc42() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 20 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalcThree0() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 10, 10, 10 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(12.87));
	}

	@Test
	public void testCalcThree1() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 10, 10, 10 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(16.58));
	}

	@Test
	public void testCalcThree2() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 10, 10, 10 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(20.67));
	}

	@Test
	public void testCalcThree3() {
		WinRateCalculator cbc = new WinRateCalculator(new int[] { 10, 10, 10 }, 3, 20);
		assertThat(cbc.getWinRate(), equalTo(25.15));
	}

}
