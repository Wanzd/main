package com.pd.it.service.api;

import java.util.List;

import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryListOperation;

public interface IQueryListService<FO, DTO> {

	default List<DTO> queryList(FO fo) {
		IQueryListOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryListOperation.class, "dao");
		return operation.queryList(fo);
	}

}
