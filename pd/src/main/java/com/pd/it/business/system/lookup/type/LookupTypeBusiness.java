package com.pd.it.business.system.lookup.type;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.common.vo.FO;
import com.pd.it.system.lookup.type.LookupTypeService;

@Named
public class LookupTypeBusiness {

	@Inject
	private LookupTypeService service;

	public Object queryList(FO in) {
		return service.queryList(in);
	}

}
