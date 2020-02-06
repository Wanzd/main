package com.pd.it.business.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.service.impl.SariBaseService;
import com.pd.it.service.impl.SariCityService;
import com.pd.it.service.impl.SariProvinceService;

@Named
public class SariBusiness {
	@Inject
	private SariProvinceService provinceService;
	@Inject
	private SariCityService cityService;
	@Inject
	private SariBaseService baseService;

	public void process(MapVO fo) {
		List<MapVO> sariNews = baseService.queryList(new MapVO());

		//provinceService.truncate();
		cityService.truncate();
		for (MapVO eachVO : sariNews) {
			init(eachVO);
			//provinceService.process(eachVO);
			cityService.process(eachVO);
		}
	}

	private void init(MapVO fo) {
		fo.put("value", fo.str("value").replaceAll("\r\n", ";").replaceAll("人、", "例、").replaceAll("确诊", " 确诊 ")
				.replaceAll("州", "州 "));
	}

}
