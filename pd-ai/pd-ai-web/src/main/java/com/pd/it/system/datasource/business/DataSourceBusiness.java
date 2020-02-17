package com.pd.it.system.datasource.business;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.app.sari.builder.DataSourceViewBuilder;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IQueryOperation;
import com.pd.it.system.datasource.service.SystemDataSourceService;

@Named
public class DataSourceBusiness implements IQueryOperation<MapVO, Object> {
	private static Map<String, IBuilder<MapVO, Object>> builderMap = initBuilderMap();
	@Inject
	private SystemDataSourceService service;

	@Override
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
		return opMap;
	}
}
