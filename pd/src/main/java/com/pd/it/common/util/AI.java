package com.pd.it.common.util;

public class AI {

	public static <IN> IN nvl(IN in, IN defaultRs) {
		return in == null ? defaultRs : in;
	}

}
