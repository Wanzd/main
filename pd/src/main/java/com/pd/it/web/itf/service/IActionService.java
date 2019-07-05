package com.pd.it.web.itf.service;

import com.pd.it.common.itf.IAction;

public interface IActionService extends IAction {

	@Override
	default Object execute(Object fo) {
		Object validRa = valid(fo);
		return validRa != null ? validRa : run(fo);
	}

	default Object valid(Object fo) {
		return null;
	};

	Object run(Object fo);

}
