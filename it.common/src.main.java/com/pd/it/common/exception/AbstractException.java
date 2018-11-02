package com.pd.it.common.exception;

import com.pd.it.common.util.Format;
import com.pd.it.common.vo.ResultVO;

public class AbstractException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4422896828370293725L;

	private Object[] in;

	public AbstractException init(Object... in) {
		this.in = in;
		return this;
	}

	@Override
	public String getMessage() {
		ExceptionAnnotation declaredAnnotation = this.getClass().getDeclaredAnnotation(ExceptionAnnotation.class);
		String msgTpl = declaredAnnotation.msgTpl();
		String msg = Format.str(msgTpl, in);
		return ResultVO.error(msg).toString();
	}
}
