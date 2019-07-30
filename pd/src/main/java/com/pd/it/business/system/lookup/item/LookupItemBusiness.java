package com.pd.it.business.system.lookup.item;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.model.system.lookup.item.LookupItemFO;
import com.pd.it.service.system.lookup.item.LookupItemService;

@Named
public class LookupItemBusiness {

	@Inject
	private LookupItemService service;

	public Object queryList(LookupItemFO in) {
		return service.queryList(in);
	}

}
