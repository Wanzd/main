package com.pd.it.system.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;

@Service
public class ChartService implements IQueryService {

	@Autowired
	protected IChartDao dao;

}
