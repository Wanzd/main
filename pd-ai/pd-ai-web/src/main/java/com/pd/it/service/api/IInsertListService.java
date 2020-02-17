package com.pd.it.service.api;

import java.util.List;

import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IInsertListOperation;

public interface IInsertListService<VO> {

	default int insertList(List<VO> list) {
		IInsertListOperation<VO> operation = Reflects.firstExistField(this, IInsertListOperation.class, "dao");
		return operation.insertList(list);
	}

}
