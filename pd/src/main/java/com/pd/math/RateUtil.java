package com.pd.math;

import com.pd.base.DoubleValid;

public class RateUtil {

	/**
	 * 通过每一次尝试的成功概率oneRate和期望成功targetRate概率求需要尝试的平均次数
	 * 
	 * @param oneRate
	 * @param targetRate
	 * @return
	 */
	public static double getTimesByOneRate(double oneRate, double targetRate) {
		DoubleValid.match(oneRate, "0<value<1");
		DoubleValid.match(targetRate, "0<value<1");

		return Math.log(1 - targetRate) / Math.log(1 - oneRate);
	}

}
