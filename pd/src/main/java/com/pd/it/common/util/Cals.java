package com.pd.it.common.util;

public class Cals {
	public static <In> In nvl(In in, In defaultValue) {
		return in != null ? in : defaultValue;
	}
}
