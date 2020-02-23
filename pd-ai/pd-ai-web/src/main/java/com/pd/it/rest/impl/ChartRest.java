package com.pd.it.rest.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.app.sari.builder.ChartStackLineBuilder;
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
	private static Map<String, IBuilder<List<MapVO>, List<MapVO>>> builderMap = initBuilderMap();
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
		List<MapVO> list = dataSourceBusiness.queryList(rs);
		IBuilder<List<MapVO>, List<MapVO>> chartBuilder = builderMap.get(rs.str("chartType"));
		if (chartBuilder != null) {
			chartBuilder.init(rs);
			list = chartBuilder.build(list);
		}
		rs.put("list", list);
		return rs;
	}

	/**
	 * 初始化执行器地图
	 * 
	 * @return
	 */
	private static Map<String, IBuilder<List<MapVO>, List<MapVO>>> initBuilderMap() {
		Map<String, IBuilder<List<MapVO>, List<MapVO>>> opMap = new HashMap<>();
		opMap.put("stackLine", new ChartStackLineBuilder());
		return opMap;
	}
}
