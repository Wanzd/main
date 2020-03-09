package com.pd.it.app.sari.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.base.news.dao.IBaseNewsDao;
import com.pd.it.service.api.IDeleteService;
import com.pd.it.service.api.IInsertListService;
import com.pd.it.service.api.IQueryListService;

@Named
public class SariBaseService
		implements IQueryListService<MapVO, MapVO>, IInsertListService<MapVO>, IDeleteService<MapVO> {
	@Inject
	private IBaseNewsDao dao;
}
