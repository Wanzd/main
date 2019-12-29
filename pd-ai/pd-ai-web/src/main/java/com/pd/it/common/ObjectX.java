package com.pd.it.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ObjectX {
	public static <IN, OUT> OUT x(IN in, Class<OUT> outClass) {
		String jsonString = JSON.toJSONString(in);
		JSONObject jo = JSON.parseObject(jsonString);
		return JSON.toJavaObject(jo, outClass);
	}
}
