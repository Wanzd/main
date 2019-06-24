package com.pd.it.system.datasource;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;
import com.pd.it.web.itf.service.ISaveService;

@Service
public class DataSourceService implements IQueryService, ISaveService {

	@Inject
	protected IDataSourceDao dao;

}
