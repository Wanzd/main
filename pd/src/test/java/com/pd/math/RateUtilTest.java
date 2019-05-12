package com.pd.math;

import org.junit.Test;

class RateUtilTest {

	@Test
	void testGetTimesByOneRate() {
		System.out.println(RateUtil.getTimesByOneRate(0.0001, 0.99));
		System.out.println(RateUtil.getTimesByOneRate(0.125, 0.618));
		System.out.println(RateUtil.getTimesByOneRate(0.125, 0.9));
		System.out.println(RateUtil.getTimesByOneRate(0.125, 0.99));
		System.out.println(RateUtil.getTimesByOneRate(0.6, 0.99));
	}

}
