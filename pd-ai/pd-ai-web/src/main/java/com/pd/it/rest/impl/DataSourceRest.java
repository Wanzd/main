package com.pd.it.rest.impl;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;
import com.pd.it.system.datasource.business.DataSourceBusiness;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class DataSourceRest {
	@Inject
	private DataSourceBusiness business;

	@RequestMapping(value = "/DS:{dataSourceId}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object query(@PathVariable String dataSourceId) {
		MapVO fo = new MapVO();
		fo.put("dataSourceId", dataSourceId);
		return business.queryList(fo);
	}
}
