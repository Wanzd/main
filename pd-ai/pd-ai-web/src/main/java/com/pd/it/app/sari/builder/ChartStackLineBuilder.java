package com.pd.it.app.sari.builder;

import java.util.Comparator;
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
			String maxX = lv2Map.str("maxX");
			String curX = eachVO.str(xCol);
			if (curX.compareTo(maxX) > 0) {
				lv2Map.put("maxX", curX);
				lv2Map.put("lastX", eachVO.num(yCol));
			}
			lv2List.add(eachVO);
		}
		List<MapVO> collect = tmpMap.values().stream().collect(Collectors.toList());
		collect.sort(new Comparator<MapVO>() {
			public int compare(MapVO v1, MapVO v2) {
				return Double.valueOf(v2.num("lastX")).compareTo(v1.num("lastX"));
			}
		});
		return collect;
	}

	@Override
	public void init(MapVO mapVO) {
		this.mapVO = mapVO;
	}
}
