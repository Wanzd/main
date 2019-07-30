package com.pd.it.service.system.lookup.item;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.dao.system.lookup.item.ILookupItemDao;
import com.pd.it.model.system.lookup.item.LookupItemFO;

@Named
public class LookupItemService {

	@Inject
	private ILookupItemDao dao;

	public Object queryList(LookupItemFO in) {
		return dao.queryList(in);
	}

}
