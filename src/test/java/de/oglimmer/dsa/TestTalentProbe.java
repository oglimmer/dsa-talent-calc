package de.oglimmer.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class TestTalentProbe {

	// taw=0

	// simple checks

	@Test
	public void DieRollTest10_10_10_0_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(10) }, 0);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest10_10_11_0_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(11) }, 0);
		assertThat(tp.check(), equalTo(false));
	}

	@Test
	public void DieRollTest10_10_09_0_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(9) }, 0);
		assertThat(tp.check(), equalTo(true));
	}

	// check for double-1

	@Test
	public void DieRollTest01_01_20_0_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(1), Trial.attr(10).roll(1),
				Trial.attr(10).roll(20) }, 0);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest20_01_01_0_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(20), Trial.attr(10).roll(1),
				Trial.attr(10).roll(1) }, 0);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest01_20_01_0_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(1), Trial.attr(10).roll(20),
				Trial.attr(10).roll(1) }, 0);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest20_01_01_MIN20_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(20), Trial.attr(10).roll(1),
				Trial.attr(10).roll(1) }, -20);
		assertThat(tp.check(), equalTo(true));
	}

	// check for double-20

	@Test
	public void DieRollTest01_20_20_20_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(1), Trial.attr(10).roll(20),
				Trial.attr(10).roll(20) }, 20);
		assertThat(tp.check(), equalTo(false));
	}

	@Test
	public void DieRollTest20_01_20_20_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(20), Trial.attr(10).roll(1),
				Trial.attr(10).roll(20) }, 20);
		assertThat(tp.check(), equalTo(false));
	}

	@Test
	public void DieRollTest20_20_01_20_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(20), Trial.attr(10).roll(20),
				Trial.attr(10).roll(1) }, 20);
		assertThat(tp.check(), equalTo(false));
	}

	// taw=1

	@Test
	public void DieRollTest10_10_10_1_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(10) }, 1);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest10_10_11_1_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(11) }, 1);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest10_10_12_1_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(12) }, 1);
		assertThat(tp.check(), equalTo(false));
	}

	@Test
	public void DieRollTest10_10_09_1_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(10), Trial.attr(10).roll(10),
				Trial.attr(10).roll(9) }, 1);
		assertThat(tp.check(), equalTo(true));
	}

	// taw= edge cases

	@Test
	public void DieRollTest15_15_15_15_Success() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(15), Trial.attr(9).roll(14),
				Trial.attr(11).roll(16) }, 15);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest15_15_15_14_Fail() {
		DSATalentTest tp = new DSATalentTest(new Trial[] { Trial.attr(10).roll(15), Trial.attr(10).roll(15),
				Trial.attr(10).roll(15) }, 14);
		assertThat(tp.check(), equalTo(false));
	}

	@Test
	public void DieRollTest03_03_03_MIN7_Success() {
		DSATalentTest tp = new DSATalentTest(
				new Trial[] { Trial.attr(10).roll(3), Trial.attr(11).roll(4), Trial.attr(12).roll(5) }, -7);
		assertThat(tp.check(), equalTo(true));
	}

	@Test
	public void DieRollTest03_03_04_MIN7_Fail() {
		DSATalentTest tp = new DSATalentTest(
				new Trial[] { Trial.attr(10).roll(3), Trial.attr(10).roll(3), Trial.attr(10).roll(4) }, -7);
		assertThat(tp.check(), equalTo(false));
	}
}
