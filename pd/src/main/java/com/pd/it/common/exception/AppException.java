package com.pd.it.common.exception;

public class AppException extends Exception {

	public AppException(String msg, Exception e) {
		super(msg, e);
	}

}
