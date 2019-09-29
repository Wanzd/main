package com.pd.it.business.system.menu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.it.common.exception.AppException;
import com.pd.it.model.system.menu.MenuFO;
import com.pd.it.model.system.menu.MenuVO;
import com.pd.it.service.system.menu.MenuService;

@Named
public class MenuBusiness {

	@Inject
	private MenuService service;

	public List<MenuVO> queryList(MenuFO in) throws AppException {
		return service.queryList(in);
	}

}
