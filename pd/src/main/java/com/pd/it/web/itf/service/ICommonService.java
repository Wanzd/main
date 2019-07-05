package com.pd.it.web.itf.service;

import com.pd.it.common.itf.INamedMethodAction;

public interface ICommonService extends INamedMethodAction, IQueryService, ISaveService, IExcelService {
	@Override
	default Object execute(String methodName, Object in) {
		return null;
	}
}
