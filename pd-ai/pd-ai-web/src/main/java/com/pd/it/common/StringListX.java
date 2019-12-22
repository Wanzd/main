package com.pd.it.common;

import java.util.ArrayList;
import java.util.List;

public class StringListX {
	public static <IN> List<String> listAttr(List<IN> inList, String attrName) {
		List<String> rsList = new ArrayList<>();
		for (Object eachVO : inList) {
			rsList.add(StringX.attr(eachVO, attrName));
		}
		return rsList;
	}
}
