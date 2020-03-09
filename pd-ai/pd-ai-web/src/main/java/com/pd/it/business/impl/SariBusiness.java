package com.pd.it.business.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.app.sari.service.SariBaseService;
import com.pd.it.app.sari.service.SariCityService;
import com.pd.it.app.sari.service.SariNationService;
import com.pd.it.app.sari.service.SariProvinceService;
import com.pd.it.base.WebUtil;
import com.pd.it.common.ListX;

@Named
public class SariBusiness {
	@Inject
	private SariNationService nationService;
	@Inject
	private SariProvinceService provinceService;
	@Inject
	private SariCityService cityService;
	@Inject
	private SariBaseService baseService;

	public void process(MapVO fo) {
		fo.put("type", "sari");
		List<MapVO> list = baseService.queryList(fo);
		if (list.size() == 0) {
			String httpStr = WebUtil.post("https://www.zhihu.com/2019-nCoV/trends", null);
			MapVO vo = new MapVO();
			vo.put("type", "sari");
			vo.put("creationDate", new Date());
			vo.put("parseBean", "html");
			vo.put("value", httpStr);
			List<MapVO> insertList = ListX.as(vo);
			baseService.insertList(insertList);
			list = baseService.queryList(fo);
		}
		init(list);
		processNation(fo, list);
		processProvince(fo, list);
		processCity(fo, list);
	}

	private void processCity(MapVO fo, List<MapVO> list) {
		cityService.delete(fo);
		for (MapVO eachVO : list) {
			cityService.process(eachVO);
		}
	}

	private void processProvince(MapVO fo, List<MapVO> list) {
		provinceService.delete(fo);
		for (MapVO eachVO : list) {
			provinceService.process(eachVO);
		}
	}

	private void processNation(MapVO fo, List<MapVO> list) {
		nationService.delete(fo);
		for (MapVO eachVO : list) {
			nationService.process(eachVO);
		}
	}

	private void init(List<MapVO> list) {
		for (MapVO eachVO : list) {
			eachVO.put("value", eachVO.str("value").replaceAll("\r\n", ";").replaceAll("人、", "例、")
					.replaceAll("确诊", " 确诊 ").replaceAll("州", "州 ").replaceAll("省", " "));
		}
	}

	public void init(MapVO fo) {
		fo.put("type", "sari");
		baseService.delete(fo);
	}

}
