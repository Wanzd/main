package com.pd.it.rest.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
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
		String jsonData = queryJson(jo);
		if (jsonData == null) {
			return jsonData;
		}
		MapVO rs = new MapVO(jsonData);
		Object list = dataSourceBusiness.query(rs);
		rs.put("list", list);
		return rs;
	}

	@RequestMapping(value = "/refresh", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object refresh() throws SQLException {
		List<MapVO> list = dao.queryList(null);
		list.stream().forEach(vo -> vo.put("jsonData", JSON.toJSONString(vo)));
		dao.updateList(list);
		return 0;
	}

}
