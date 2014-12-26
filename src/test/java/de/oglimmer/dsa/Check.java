package de.oglimmer.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class Check {

	@Test
	public void testCalc1() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 10 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc2() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 5 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc3() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 15 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc11() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 9 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc21() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 4 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc31() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 14 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc111() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 8 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(50.0));
	}

	@Test
	public void testCalc211() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 3 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(25.0));
	}

	@Test
	public void testCalc311() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 13 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(75.0));
	}

	@Test
	public void testCalc4() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 20 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalc41() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 20 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalc42() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 20 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(95.0));
	}

	@Test
	public void testCalcThree0() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 10, 10, 10 }, 0, 20);
		assertThat(cbc.getWinRate(), equalTo(12.5));
	}

	@Test
	public void testCalcThree1() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 10, 10, 10 }, 1, 20);
		assertThat(cbc.getWinRate(), equalTo(16.25));
	}

	@Test
	public void testCalcThree2() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 10, 10, 10 }, 2, 20);
		assertThat(cbc.getWinRate(), equalTo(20.37));
	}

	@Test
	public void testCalcThree3() {
		CountBasedCalc cbc = new CountBasedCalc(new int[] { 10, 10, 10 }, 3, 20);
		assertThat(cbc.getWinRate(), equalTo(24.88));
	}

}
