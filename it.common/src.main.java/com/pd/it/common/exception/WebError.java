package com.pd.it.common.exception;

public class WebError {

	@ExceptionAnnotation(code = "NO_SERVICE", msgTpl = "Not found Service[%s]")
	public static class NoServiceException extends AbstractException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6536396745503903470L;

	}

	@ExceptionAnnotation(code = "NO_METHOD", msgTpl = "Not found method[%s]")
	public static class NoMethodException extends AbstractException {

	}

	@ExceptionAnnotation(code = "NO_PARAMS", msgTpl = "Not found params[%s]")
	public static class NoParamsException extends AbstractException {

	}
}
