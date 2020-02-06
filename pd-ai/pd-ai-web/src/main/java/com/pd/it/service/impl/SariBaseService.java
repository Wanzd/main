package com.pd.it.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.dao.Sari.IBaseDao;
import com.pd.it.service.api.IQueryListService;

@Named
public class SariBaseService implements IQueryListService<MapVO, MapVO> {
	@Inject
	private IBaseDao dao;
}
