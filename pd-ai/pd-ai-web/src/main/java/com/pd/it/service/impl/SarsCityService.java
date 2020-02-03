package com.pd.it.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.ListUtils;

import com.pd.base.model.MapVO;
import com.pd.it.common.IntX;
import com.pd.it.dao.ISarsCityDao;

@Named
public class SarsCityService {

	@Inject
	private ISarsCityDao dao;

	public void process(MapVO fo) {
		List<MapVO> list = parse(fo);
		refreshDb(list);
	}

	private List<MapVO> parse(MapVO fo) {
		List<MapVO> rsList = new ArrayList<>();
		String inStr = fo.str("in");
		String[] strArr = inStr.split(";");
		String provinceName = "";
		for (int i = 0, total = strArr.length; i < total; i++) {
			String eachStr = strArr[i];
			if (eachStr.contains(" 确诊 ")) {
				provinceName = parseProvinceName(eachStr);
			} else {
				eachStr = eachStr.replaceAll("市", "市 ").replaceAll("县", "县 ").replaceAll("区", "区 ")
						.replaceAll("（.*区.*）", "");
				String[] cityStrArr = eachStr.split("、");
				for (String eachCityStr : cityStrArr) {
					MapVO vo = new MapVO();
					vo.put("province", provinceName);
					vo.put("city", parseCity(eachCityStr));
					vo.put("qtyType", "cnt");
					vo.put("qty", parseCnt(eachCityStr));
					vo.put("creationDate", new Date());
					System.out.println(vo);
					rsList.add(vo);

					MapVO vo2 = new MapVO();
					vo2.put("province", provinceName);
					vo2.put("city", parseCity(eachCityStr));
					vo2.put("qtyType", "heal");
					vo2.put("qty", parseHeal(eachCityStr));
					vo2.put("creationDate", new Date());
					System.out.println(vo2);
					rsList.add(vo2);
					MapVO vo3 = new MapVO();
					vo3.put("province", provinceName);
					vo3.put("city", parseCity(eachCityStr));
					vo3.put("qtyType", "death");
					vo3.put("qty", parseDeath(eachCityStr));
					vo3.put("creationDate", new Date());
					System.out.println(vo3);
					rsList.add(vo3);
					MapVO vo4 = new MapVO();
					vo4.put("province", provinceName);
					vo4.put("city", parseCity(eachCityStr));
					vo4.put("qtyType", "doubt");
					vo4.put("qty", parseDoubt(eachCityStr));
					vo4.put("creationDate", new Date());
					System.out.println(vo4);
					rsList.add(vo4);
				}

			}
		}
		return rsList;
	}

	private String parseProvinceName(String eachStr) {
		return eachStr.substring(0, eachStr.indexOf(" "));
	}

	private int parseDoubt(String eachStr) {
		int start = eachStr.indexOf("疑似");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 2);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseDeath(String eachStr) {
		int start = eachStr.indexOf("死亡");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 2);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseHeal(String eachStr) {
		int start = eachStr.indexOf("治愈");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 2);
		int end = eachStr.indexOf("例");
		return IntX.str(eachStr.substring(0, end));
	}

	private int parseCnt(String eachStr) {
		int start = eachStr.indexOf(" ");
		if (start < 0) {
			return 0;
		}
		eachStr = eachStr.substring(start + 1);
		int end = eachStr.indexOf("例");
		try {
			return IntX.str(eachStr.substring(0, end));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private String parseCity(String eachStr) {
		try {
			return eachStr.substring(0, eachStr.indexOf(" "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private void refreshDb(List<MapVO> rsMap) {
		List<MapVO> map = rsMap.stream().filter(vo -> vo.num("qty") > 0).collect(Collectors.toList());
		try {
			MapVO dto = new MapVO();
			dto.put("date", new Date());
			dao.delete(dto);
			List<List<MapVO>> partition = ListUtils.partition(map, 500);
			for (List<MapVO> subList : partition) {
				try {
					dao.updateList(subList);
				} catch (Exception e) {
					System.out.println(subList);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
