package com.pd.it.system;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.module.menu.MenuTreeService;
import com.pd.it.system.chart.ChartService;
import com.pd.it.system.datasource.DataSourceService;
import com.pd.it.system.datasource.DataSourceTableService;
import com.pd.it.system.lookup.LookupItemService;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system")
public class SystemRestService implements IDimensionRestService {

	@Inject
	protected ChartService chart;

	@Inject
	protected LookupItemService lookupItem;

	@Inject
	protected MenuTreeService menuTree;
	@Inject
	protected DataSourceTableService dsTable;
	@Inject
	protected DataSourceService dataSource;
}
