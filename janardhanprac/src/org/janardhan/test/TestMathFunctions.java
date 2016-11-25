package org.janardhan.test;

import static org.junit.Assert.assertTrue;

import org.janardhan.functions.MathFunctions;
import org.junit.Test;

public class TestMathFunctions {

	@Test
	public void TestForNegative() {
		assertTrue(MathFunctions.isDivisibleByThree(-1));
	}
}
