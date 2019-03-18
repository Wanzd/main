package com.pd.it.module.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;

@Service
public class MenuTreeService implements IQueryService {

	@Autowired
	protected IMenuTreeDao dao;

}
