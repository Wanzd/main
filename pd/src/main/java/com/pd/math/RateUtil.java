package com.pd.math;

import com.pd.base.DoubleValid;

public class RateUtil {

	/**
	 * ͨ��ÿһ�γ��Եĳɹ�����oneRate�������ɹ�targetRate��������Ҫ���Ե�ƽ������
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
