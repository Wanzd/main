package com.pd.it.common.vo;

public class Attr {
	private String key;
	private Object value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Attr(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
