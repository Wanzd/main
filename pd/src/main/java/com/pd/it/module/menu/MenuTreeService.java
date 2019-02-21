package com.pd.it.module.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IDbDimensionService;

@Service("menuTreeService")
public class MenuTreeService implements IDbDimensionService<IMenuTreeDao> {

	@Autowired
	private IMenuTreeDao dao;

	@Override
	public IMenuTreeDao getDao() {
		return dao;
	}

}
