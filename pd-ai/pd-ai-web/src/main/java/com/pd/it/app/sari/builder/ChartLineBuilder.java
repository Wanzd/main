package com.pd.it.app.sari.builder;

import java.util.List;

import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class ChartLineBuilder implements IBuilder<List<MapVO>, List<MapVO>> {

	private MapVO mapVO = null;

	@Override
	public List<MapVO> build(List<MapVO> in) {
		return in;
	}

	@Override
	public void init(MapVO mapVO) {
		this.mapVO = mapVO;
	}
}
