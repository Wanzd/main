package com.pd.base.model;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FO extends VO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FO() {
		super();
		init();
	}

	public FO(String inStr) {
		super();
		if (inStr != null) {
			JSONObject jsonObj = JSON.parseObject(inStr);
			for (String eachKey : jsonObj.keySet()) {
				put(eachKey, jsonObj.get(eachKey));
			}

		}
	}

	public FO(Map<String, ?> map) {
		super();
		if (map == null) {
			return;
		}
		for (String eachKey : map.keySet()) {
			put(eachKey, map.get(eachKey));
		}
	}
}
