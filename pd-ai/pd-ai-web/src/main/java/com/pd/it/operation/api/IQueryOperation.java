package com.pd.it.operation.api;

import java.util.List;

import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;

public interface IQueryOperation<FO, DTO> {
	DTO query(FO in);

	List<DTO> queryList(FO in);

	PagedResult<DTO> queryPagedList(FO in, PageVO page);
}
