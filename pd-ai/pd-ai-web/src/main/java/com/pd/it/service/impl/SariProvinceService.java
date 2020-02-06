package com.pd.it.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.common.IntX;
import com.pd.it.common.StringX;
import com.pd.it.dao.Sari.IProvinceDao;
import com.pd.it.service.api.ITruncateService;

@Named
public class SariProvinceService implements ITruncateService {

	@Inject
	private IProvinceDao dao;

	public void process(MapVO fo) {
		List<MapVO> list = parse(fo);
		refreshDb(list);
	}

	private List<MapVO> parse(MapVO fo) {
		List<MapVO> rsList = new ArrayList<>();
		String inStr = fo.str("value");
		String[] strArr = inStr.split(";");
		for (int i = 0, total = strArr.length; i < total; i++) {
			String eachStr = strArr[i];
			if (eachStr.contains(" 确诊 ")) {
				System.out.println(eachStr);
				MapVO vo = new MapVO();
				vo.put("province", parseName(eachStr));
				vo.put("qtyType", "cnt");
				vo.put("qty", parseCnt(eachStr));
				vo.put("creationDate", fo.date("creationDate"));
				System.out.println(vo);
				rsList.add(vo);

				MapVO vo2 = new MapVO();
				vo2.put("province", parseName(eachStr));
				vo2.put("qtyType", "heal");
				vo2.put("qty", parseHeal(eachStr));
				vo2.put("creationDate", fo.date("creationDate"));
				System.out.println(vo2);
				rsList.add(vo2);
				MapVO vo3 = new MapVO();
				vo3.put("province", parseName(eachStr));
				vo3.put("qtyType", "death");
				vo3.put("qty", parseDeath(eachStr));
				vo3.put("creationDate", fo.date("creationDate"));
				System.out.println(vo3);
				rsList.add(vo3);
				MapVO vo4 = new MapVO();
				vo4.put("province", parseName(eachStr));
				vo4.put("qtyType", "doubt");
				vo4.put("qty", parseDoubt(eachStr));
				vo4.put("creationDate", fo.date("creationDate"));
				System.out.println(vo4);
				rsList.add(vo4);
			}
		}
		return rsList;
	}

	private int parseDoubt(String eachStr) {
		int start = eachStr.indexOf("疑似 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 3);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseDeath(String eachStr) {
		int start = eachStr.indexOf("死亡 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 3);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseHeal(String eachStr) {
		int start = eachStr.indexOf("治愈 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 3);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseCnt(String eachStr) {
		int start = eachStr.indexOf("确诊 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 3);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private String parseName(String eachStr) {
		return eachStr.substring(0, eachStr.indexOf(" "));
	}

	private void refreshDb(List<MapVO> rsMap) {
		List<MapVO> map = rsMap.stream().filter(vo -> vo.num("qty") > 0).collect(Collectors.toList());
		try {
			dao.updateList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
