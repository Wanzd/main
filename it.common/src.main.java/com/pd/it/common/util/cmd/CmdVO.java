package com.pd.it.common.util.cmd;

public class CmdVO {

	private CmdType type;
	private String[] param;

	public CmdType getType() {
		return type;
	}

	public void setType(CmdType type) {
		this.type = type;
	}

	public String[] getParam() {
		return param;
	}

	public void setParam(String[] param) {
		this.param = param;
	}

	public CmdVO(CmdType type, String[] param) {
		super();
		this.type = type;
		this.param = param;
	}
}
