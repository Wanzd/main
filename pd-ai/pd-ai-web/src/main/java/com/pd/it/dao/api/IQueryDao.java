package com.pd.it.dao.api;

import com.pd.it.operation.api.IQueryListOperation;
import com.pd.it.operation.api.IQueryOperation;
import com.pd.it.operation.api.IQueryPagedListOperation;

public interface IQueryDao<FO, DTO>
		extends IQueryOperation<FO, DTO>, IQueryListOperation<FO, DTO>, IQueryPagedListOperation<FO, DTO>{
}
