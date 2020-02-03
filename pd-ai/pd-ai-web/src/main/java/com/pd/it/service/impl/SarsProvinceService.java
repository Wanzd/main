package com.pd.it.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.common.IntX;
import com.pd.it.common.StringX;
import com.pd.it.dao.ISarsProvinceDao;

@Named
public class SarsProvinceService {

	@Inject
	private ISarsProvinceDao dao;

	public void process(MapVO fo) {
		List<MapVO> list = parse(fo);
		refreshDb(list);
	}

	private List<MapVO> parse(MapVO fo) {
		List<MapVO> rsList = new ArrayList<>();
		String inStr = fo.str("in");
		String[] strArr = inStr.split(";");
		for (int i = 0, total = strArr.length; i < total; i++) {
			String eachStr = strArr[i];
			if (eachStr.contains(" 确诊 ")) {
				System.out.println(eachStr);
				MapVO vo = new MapVO();
				vo.put("name", parseName(eachStr));
				vo.put("cnt", parseCnt(eachStr));
				vo.put("heal", parseHeal(eachStr));
				vo.put("death", parseDeath(eachStr));
				vo.put("doubt", parseDoubt(eachStr));
				vo.put("creationDate", StringX.date(new Date(), "yyyy-MM-dd"));
				System.out.println(vo);
				rsList.add(vo);
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
		int end = eachStr.indexOf(" 例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseDeath(String eachStr) {
		int start = eachStr.indexOf(" 死亡 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 4);
		int end = eachStr.indexOf(" 例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseHeal(String eachStr) {
		int start = eachStr.indexOf(" 治愈 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 4);
		int end = eachStr.indexOf(" 例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseCnt(String eachStr) {
		int start = eachStr.indexOf(" 确诊 ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 4);
		int end = eachStr.indexOf(" 例");
		return IntX.str(eachStr.substring(0, end));
	}

	private String parseName(String eachStr) {
		return eachStr.substring(0, eachStr.indexOf(" "));
	}

	private void refreshDb(List<MapVO> rsMap) {
		try {
			MapVO dto = new MapVO();
			dto.put("date", StringX.date(new Date(), "yyyy-MM-dd"));
			dao.delete(dto);
			dao.updateList(rsMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
