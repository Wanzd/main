package com.pd.it.system.lookup;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.common.vo.FO;
import com.pd.it.system.lookup.type.LookupTypeService;

@Named
public class LookupItemBusiness {

	@Inject
	private LookupTypeService service;

	public Object queryList(FO in) {
		return service.queryList(in);
	}

}
