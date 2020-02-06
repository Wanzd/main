package com.pd.it.service.api;

import java.util.List;

import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryOperation;

public interface IQueryListService<FO, DTO> {

	default List<DTO> queryList(FO fo) {
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class, "dao");
		return operation.queryList(fo);
	}

}
