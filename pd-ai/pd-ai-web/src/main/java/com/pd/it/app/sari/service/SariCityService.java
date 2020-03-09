package com.pd.it.app.sari.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.ListUtils;

import com.pd.base.model.MapVO;
import com.pd.it.app.sari.builder.SariCityHtmlParseBuilder;
import com.pd.it.app.sari.builder.SariCityParseBuilder;
import com.pd.it.app.sari.dao.IAppSariCityDao;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.service.api.ITruncateService;

@Named
public class SariCityService implements ITruncateService {

	@Inject
	private IAppSariCityDao dao;

	public void process(MapVO fo) {
		List<MapVO> list = parse(fo);
		insertList(list);
	}

	private List<MapVO> parse(MapVO fo) {
		IBuilder<MapVO, List<MapVO>> parseBean = null;
		switch (fo.str("parseBean")) {
		case "html":
			parseBean = new SariCityHtmlParseBuilder();
			break;
		default:
			parseBean = new SariCityParseBuilder();
		}
		return parseBean.build(fo);
	}

	private void insertList(List<MapVO> rsMap) {
		List<MapVO> map = rsMap.stream().filter(vo -> vo.num("qty") > 0).collect(Collectors.toList());
		MapVO dto = new MapVO();
		dto.put("date", new Date());
		List<List<MapVO>> partition = ListUtils.partition(map, 500);
		for (List<MapVO> subList : partition) {
			try {
				dao.updateList(subList);
			} catch (Exception e) {
				System.out.println(subList);
			}
		}
	}

	public void delete(MapVO fo) {
		dao.delete(fo);
	}
}
