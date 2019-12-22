package com.pd.it.common;

import java.util.Map;

public class StringX {
	public static <IN> String attr(IN in, String attrName) {
		if (in instanceof Map) {
			return str(((Map) in).get(attrName));
		}
		return str(Reflects.field(in, attrName));
	}

	public static <IN> String str(IN in) {
		if (in == null) {
			return null;
		}
		return in.toString();
	}
}
