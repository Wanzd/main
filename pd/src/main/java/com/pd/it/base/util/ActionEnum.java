package com.pd.it.base.util;

import com.pd.it.web.action.ReadAllQueryAction;
import com.pd.it.web.action.ReadSingleQueryAction;

public enum ActionEnum {

	ra("ra", ReadAllQueryAction.class), r("r", ReadSingleQueryAction.class);

	private String key;
	private Class<?> actionService;
	private String methodName;

	ActionEnum(String key, Class<?> actionAction) {
		this.key = key;
		this.setActionService(actionService);
	}

	public Class<?> getActionService() {
		return actionService;
	}

	public void setActionService(Class<?> actionService) {
		this.actionService = actionService;
	}

}
