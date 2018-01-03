package com.pd.it.common.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

	public static Map<String, String> c(String... inStrArr) {
		Map<String, String> rsMap = new HashMap<String, String>();
		if (inStrArr == null || inStrArr.length == 0) {
			return rsMap;
		}
		for (String eachInStr : inStrArr) {
			String[] splitStrArr = eachInStr.split(":");
			if (splitStrArr.length != 2) {
				continue;
			}
			rsMap.put(splitStrArr[0], splitStrArr[1]);
		}
		return rsMap;
	}
}
