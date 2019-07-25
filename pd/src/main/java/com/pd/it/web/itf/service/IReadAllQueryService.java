package com.pd.it.web.itf.service;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IDao;

public interface IReadAllQueryService extends IActionService {

	@Override
	default Object run(Object vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.queryList(vo);
	};

}
