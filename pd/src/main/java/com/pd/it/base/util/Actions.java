package com.pd.it.base.util;

import com.pd.it.common.itf.IAction;
import com.pd.it.common.itf.IDimensionRestService;

public class Actions {

	public static IAction getAction(IDimensionRestService dimensionService, String dimension, String actionName) {
		ActionEnum actionEnum = ActionEnum.valueOf(actionName);
		if (actionEnum == null) {
			return null;
		}
		Class<?> class1 = actionEnum.getActionService();
		Object service = Reflects.field(dimensionService, class1, dimension, dimension + "Service");
		if (service instanceof IAction) {
			IAction actionImpl = (IAction) service;
			return actionImpl;
		}
		return null;
	}

}
