package com.pd.it.operation.api;

import java.util.List;

import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;
import com.pd.it.common.Reflects;
import com.pd.it.dao.api.IQueryDao;

public interface IQueryOperationImpl<FO, DTO> extends IQueryOperation<FO, DTO> {
	default DTO query(FO in) {
		IQueryDao<FO, DTO> dao = Reflects.field(this, "dao", IQueryDao.class);
		return dao.query(in);
	}

	default List<DTO> queryList(FO in) {
		IQueryDao<FO, DTO> dao = Reflects.field(this, "dao", IQueryDao.class);
		return dao.queryList(in);
	}

	default PagedResult<DTO> queryPagedList(FO in, PageVO page) {
		IQueryDao<FO, DTO> dao = Reflects.field(this, "dao", IQueryDao.class);
		return dao.queryPagedList(in, page);
	}
}
