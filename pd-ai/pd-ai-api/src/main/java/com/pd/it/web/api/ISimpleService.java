package com.pd.it.web.api;

import com.pd.it.common.Reflects;

public interface ISimpleService extends IService {
	default Object get(Object in) {
		ISimpleDao dao = Reflects.field(this, "dao", ISimpleDao.class);
		return dao.get(in);
	}
}
