package com.pd.it.business.system.menu;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.model.system.menu.MenuFO;
import com.pd.it.service.system.menu.MenuService;

@Named
public class MenuBusiness {

	@Inject
	private MenuService service;

	public Object queryList(MenuFO in) {
		return service.queryList(in);
	}

}
