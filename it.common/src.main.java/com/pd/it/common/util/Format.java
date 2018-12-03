package com.pd.it.common.util;

import java.util.Date;

import com.pd.it.common.vo.VO;

public class Format {

	public static final String DT = "yyyy/MM/dd HH:mm:ss.SSS";

	public static String freeMark(String tmplate, VO vo) {
		return FreeMarkerUtil.cal(tmplate, vo);
	}

	public static String v(VO in, String key) {
		Object value = in.get(key);
		return value == null ? null : value.toString();

	}

	public static String str(String string, Object... params) {
		return String.format(string, params);
	}

	public static String date(Date date, String pattern) {
		return DateUtil.format(date, pattern);
	}

	public static String date(Date date) {
		return DateUtil.format(date, DT);
	}

	public static String date$now() {
		return DateUtil.format(new Date(), DT);
	}

}
