package com.pd.it.system.datasource.business;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.sys.datasource.builder.DataSourceObjBuilder;
import com.pd.it.sys.datasource.builder.DataSourceViewBuilder;
import com.pd.it.system.datasource.service.SystemDataSourceService;

@Named
public class DataSourceBusiness {
	private static Map<String, IBuilder<MapVO, Object>> builderMap = initBuilderMap();
	@Inject
	private SystemDataSourceService service;

	public Object query(MapVO fo) {
		MapVO map = service.query(fo);
		if (map == null) {
			return null;
		}
		IBuilder<MapVO, Object> opBuilder = builderMap.get(map.str("type"));
		return opBuilder.build(map);
	}

	/**
	 * 初始化执行器地图
	 * 
	 * @return
	 */
	private static Map<String, IBuilder<MapVO, Object>> initBuilderMap() {
		Map<String, IBuilder<MapVO, Object>> opMap = new HashMap<>();
		opMap.put("view", new DataSourceViewBuilder());
		opMap.put("obj", new DataSourceObjBuilder());
		return opMap;
	}
}
