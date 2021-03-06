package com.pd.it.common.vo;

public class ResultVO extends VO {

	private static final long serialVersionUID = -143398554658907794L;

	public static enum Status {
		Success, Fail, Error
	}

	private ResultVO(Status status, Object msgVO, String code) {
		super();
		put("msg", msgVO == null ? null : msgVO.toString());
		put("status", status);
		put("code", code);
	}

	public static ResultVO success(Object msg) {
		// TODO Auto-generated method stub
		return new ResultVO(Status.Success, msg, "200");
	}

}
