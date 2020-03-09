package com.pd.it.app.sari.builder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class ChartTimeLineBuilder implements IBuilder<List<MapVO>, List<MapVO>> {

	private MapVO mapVO = null;

	@Override
	public List<MapVO> build(List<MapVO> in) {
		Map<String, MapVO> tmpMap = new HashMap<>();
		for (MapVO eachVO : in) {
			MapVO lv2Map = tmpMap.get(eachVO.str("date"));
			List<MapVO> lv2List = null;
			if (lv2Map == null) {
				lv2Map = new MapVO();
				tmpMap.put("date", lv2Map);
			}
			lv2List = lv2Map.list("list");
			lv2List.add(eachVO);
		}
		List<MapVO> collect = tmpMap.values().stream().collect(Collectors.toList());
		return collect;
	}

	@Override
	public void init(MapVO mapVO) {
		this.mapVO = mapVO;
	}
}
