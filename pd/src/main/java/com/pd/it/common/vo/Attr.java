package com.pd.it.common.vo;

import lombok.Data;

@Data
public class Attr {
	private String key;
	private Object value;

	public Attr(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
