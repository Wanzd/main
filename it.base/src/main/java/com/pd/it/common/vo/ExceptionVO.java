package com.pd.it.common.vo;

public class ExceptionVO extends VO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7930813616137139164L;

	public ExceptionVO(String exceptionType, String msg) {
		super();
		put("exceptionType", exceptionType);
		put("msg", msg);
	}
}
