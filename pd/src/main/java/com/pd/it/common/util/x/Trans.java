package com.pd.it.common.util.x;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Trans {

	public static <Out> Out obj(Object in, Class<Out> outClass) {
		String jsonString = JSON.toJSONString(in);
		return JSON.parseObject(jsonString, outClass);
	}

	public static <Out> List<Out> list(List in, Class<Out> outClass) {
		List<Out> rsList = new ArrayList<>();
		for (Object eachVO : in) {
			rsList.add(obj(eachVO, outClass));
		}
		return rsList;
	}
}
