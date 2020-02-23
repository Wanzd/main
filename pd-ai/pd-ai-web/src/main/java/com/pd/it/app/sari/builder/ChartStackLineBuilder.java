package com.pd.it.app.sari.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class ChartStackLineBuilder implements IBuilder<List<MapVO>, List<MapVO>> {

	private MapVO mapVO = null;

	@Override
	public List<MapVO> build(List<MapVO> in) {
		Map<String, MapVO> tmpMap = new HashMap<>();
		String xCol = mapVO.str("xCol");
		String yCol = mapVO.str("yCol");
		String zCol = mapVO.str("zCol");
		for (MapVO eachVO : in) {
			MapVO lv2Map = tmpMap.get(eachVO.str(zCol));
			List<MapVO> lv2List = null;
			if (lv2Map == null) {
				lv2Map = new MapVO();
				lv2Map.put(zCol, eachVO.str(zCol));
				tmpMap.put(eachVO.str(zCol), lv2Map);
			}
			lv2List = lv2Map.list("list");
			lv2List.add(eachVO);
		}

		return tmpMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public void init(MapVO mapVO) {
		this.mapVO = mapVO;
	}
}
