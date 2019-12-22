package com.pd.base.model;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FilterObject extends MapVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterObject() {
		super();
		init();
	}

	public FilterObject(String inStr) {
		super();
		if (inStr != null) {
			JSONObject jsonObj = JSON.parseObject(inStr);
			for (String eachKey : jsonObj.keySet()) {
				put(eachKey, jsonObj.get(eachKey));
			}

		}
	}

	public FilterObject(Map<String, ?> map) {
		super();
		if (map == null) {
			return;
		}
		for (String eachKey : map.keySet()) {
			put(eachKey, map.get(eachKey));
		}
	}
}
