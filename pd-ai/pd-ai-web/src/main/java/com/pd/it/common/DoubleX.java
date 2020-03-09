package com.pd.it.common;

public class DoubleX {
	public static double str(String str) {
		if (str == null) {
			return 0D;
		}
		str=str.trim();
		try {
			return Double.valueOf(str);
		} catch (NumberFormatException e) {
			return 0D;
		}
	}
}
