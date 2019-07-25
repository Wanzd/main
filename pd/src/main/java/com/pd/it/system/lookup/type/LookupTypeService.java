package com.pd.it.system.lookup.type;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.common.vo.FO;

@Named
public class LookupTypeService {

	@Inject
	private ILookupTypeDao dao;

	public Object queryList(FO in) {
		return dao.queryList(in);
	}

}
