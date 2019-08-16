package com.pd.it.service.system.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.dao.system.menu.MenuDao;
import com.pd.it.model.system.menu.MenuFO;

@Service
public class MenuService {

	@Autowired
	protected MenuDao dao;

	public Object queryList(MenuFO in) {
		// TODO Auto-generated method stub
		return dao.queryList(in);
	}

}
