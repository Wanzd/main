package com.pd.it.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.system.chart.ChartService;
import com.pd.it.system.lookup.LookupItemService;
import com.pd.it.system.lookup.LookupTypeService;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system")
public class SystemRestService implements IDimensionRestService {

	@Autowired
	protected ChartService chart;

	@Autowired
	protected LookupTypeService lookupType;
	
	@Autowired
	protected LookupItemService lookupItem;
}
