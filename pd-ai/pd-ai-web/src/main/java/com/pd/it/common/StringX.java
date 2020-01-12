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

	public static String cap(String dimension) {
		if (dimension == null || dimension.length() == 0) {
			return dimension;
		}
		return dimension.substring(0, 1).toUpperCase() + dimension.substring(1);
	}

	public static String decap(String dimension) {
		if (dimension == null || dimension.length() == 0) {
			return dimension;
		}
		return dimension.substring(0, 1).toLowerCase() + dimension.substring(1);
	}
}
