package com.pd.it.common.util;

public class LogUtil {
	public static void function() {
		log(new Exception().getStackTrace()[1]);
	}

	public static void success() {
		debug("success", new Exception().getStackTrace()[1]);
	}

	public static void fail() {
		debug("fail", new Exception().getStackTrace()[1]);
	}

	public static void log(Object _str) {
		System.out.println(_str);
	}

	public static void debug(Object... _str) {
		if (_str.length > 1) {
			for (Object evenStr : _str) {
				System.out.print("\t|" + evenStr);
			}
			System.out.println();
		} else {
			System.out.println("\t" + _str[0]);
		}
	}

	public static void err(Exception _str) {
		System.err.println(_str);
	}

}
