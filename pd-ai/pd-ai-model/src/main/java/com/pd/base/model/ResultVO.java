package com.pd.base.model;

import lombok.Data;

@Data
public class ResultVO {

	private String msg;
	private String httpCode;
	private Object result;

	public static ResultVO NOT_SUPPORT = new ResultVO("NOT_SUPPORT", "403", null);

	public ResultVO() {
	}

	public ResultVO(String httpCode, String msg, Object result) {
		this.httpCode = httpCode;
		this.msg = msg;
		this.result = result;
	}
}
