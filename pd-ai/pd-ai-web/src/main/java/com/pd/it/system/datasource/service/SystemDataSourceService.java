package com.pd.it.system.datasource.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.service.api.IQueryService;
import com.pd.it.system.datasource.dao.ISystemDataSourceDao;

@Named
public class SystemDataSourceService implements IQueryService<MapVO, MapVO> {

	@Inject
	private ISystemDataSourceDao dao;

	@Override
	public MapVO query(MapVO dsId) {
		return dao.query(dsId);
	}

}
