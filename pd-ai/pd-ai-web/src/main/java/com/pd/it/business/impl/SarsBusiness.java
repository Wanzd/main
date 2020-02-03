package com.pd.it.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.service.impl.SarsCityService;
import com.pd.it.service.impl.SarsProvinceService;

@Named
public class SarsBusiness {
	@Inject
	private SarsProvinceService provinceService;
	@Inject
	private SarsCityService cityService;

	public void process(MapVO fo) {
		init(fo);
		// provinceService.process(fo);
		cityService.process(fo);
	}

	private void init(MapVO fo) {
		fo.put("in", fo.str("in").replaceAll("\r\n", ";").replaceAll("人、", "例、").replaceAll("确诊", " 确诊 "));
	}

}
