package com.pd.it.rest.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.system.chart.dao.ISystemChartDao;
import com.pd.it.system.datasource.business.DataSourceBusiness;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class ChartRest implements IQueryRest<MapVO, MapVO> {
	@Inject
	private ISystemChartDao dao;
	@Inject
	private DataSourceBusiness dataSourceBusiness;

	@RequestMapping(value = "/CHART:{chartId}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object query(@PathVariable String chartId) {
		MapVO fo = new MapVO();
		fo.put("id", chartId);
		JSONObject jo = ObjectX.x(fo, JSONObject.class);
		MapVO rs = query(jo);
		if (rs == null) {
			return rs;
		}
		Object list = dataSourceBusiness.query(rs);
		rs.put("list", list);
		return rs;
	}

}
