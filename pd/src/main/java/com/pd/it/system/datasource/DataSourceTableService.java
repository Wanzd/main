package com.pd.it.system.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.system.chart.IChartDao;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class DataSourceTableService implements IQueryService {

	@Autowired
	protected IDataSourceTableDao dao;

}
