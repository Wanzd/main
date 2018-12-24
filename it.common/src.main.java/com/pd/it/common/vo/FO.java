package com.pd.it.common.vo;

import java.util.Map;

public class FO extends VO<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FO() {
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
