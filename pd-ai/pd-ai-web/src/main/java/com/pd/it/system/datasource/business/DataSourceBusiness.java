package com.pd.it.system.datasource.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.app.sari.builder.DataSourceViewBuilder;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IQueryListOperation;
import com.pd.it.system.datasource.service.SystemDataSourceService;

@Named
public class DataSourceBusiness implements IQueryListOperation<MapVO, MapVO> {
	private static Map<String, IBuilder<MapVO, List<MapVO>>> builderMap = initBuilderMap();
	@Inject
	private SystemDataSourceService service;

	@Override
	public List<MapVO> queryList(MapVO fo) {
		MapVO map = service.query(fo);
		if (map == null) {
			return null;
		}
		IBuilder<MapVO, List<MapVO>> opBuilder = builderMap.get(map.str("type"));
		return opBuilder.build(map);
	}

	/**
	 * 初始化执行器地图
	 * 
	 * @return
	 */
	private static Map<String, IBuilder<MapVO, List<MapVO>>> initBuilderMap() {
		Map<String, IBuilder<MapVO, List<MapVO>>> opMap = new HashMap<>();
		opMap.put("view", new DataSourceViewBuilder());
		return opMap;
	}
}
