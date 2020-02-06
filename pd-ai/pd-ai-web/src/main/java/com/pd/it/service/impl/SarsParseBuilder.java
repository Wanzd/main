package com.pd.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pd.base.model.MapVO;
import com.pd.it.common.IntX;
import com.pd.it.common.itf.IBuilder;

public class SarsParseBuilder implements IBuilder<MapVO, List<MapVO>> {

	@Override
	public List<MapVO> build(MapVO in) {
		List<MapVO> rsList = new ArrayList<>();
		String inStr = in.str("value");
		String[] strArr = inStr.split(";");
		Object provinceName = "";
		for (int i = 0, total = strArr.length; i < total; i++) {
			String eachStr = strArr[i];
			if (eachStr.contains(" 确诊 ")) {
				provinceName = parseAttr("provinceName", eachStr);
			} else {
				eachStr = eachStr.replaceAll("市", "市 ").replaceAll("县", "县 ").replaceAll("区", "区 ")
						.replaceAll("（.*区.*）", "");
				String[] cityStrArr = eachStr.split("、");
				String[] attrNames = new String[] { "cnt", "heal", "death", "doubt" };
				for (String eachCityStr : cityStrArr) {
					for (String eachAttrName : attrNames) {
						MapVO vo = new MapVO();
						vo.put("province", provinceName);
						vo.put("city", parseAttr("city", eachCityStr));
						vo.put("qtyType", "cnt");
						vo.put("qty", parseAttr(eachAttrName, eachCityStr));
						vo.put("creationDate", in.date("creationDate"));
						rsList.add(vo);
					}
				}
			}
		}
		return rsList;
	}

	private Object parseAttr(String attrName, String eachStr) {
		Object attrValue = null;
		int start = -1;
		int end = -1;
		switch (attrName) {
		case "provinceName":
			attrValue = eachStr.substring(0, eachStr.indexOf(" "));
			break;
		case "doubt":
			start = eachStr.indexOf("疑似");
			if (start < 0) {
				return 0;
			}
			eachStr = eachStr.substring(start + 2);
			end = eachStr.indexOf("例");
			attrValue = IntX.str(eachStr.substring(0, end));
			break;
		case "death":
			start = eachStr.indexOf("死亡");
			if (start < 0) {
				return 0;
			}
			eachStr = eachStr.substring(start + 2);
			end = eachStr.indexOf("例");
			attrValue = IntX.str(eachStr.substring(0, end));
			break;
		case "heal":
			start = eachStr.indexOf("治愈");
			if (start < 0) {
				return 0;
			}
			eachStr = eachStr.substring(start + 2);
			end = eachStr.indexOf("例");
			attrValue = IntX.str(eachStr.substring(0, end));
			break;
		case "cnt":
			start = eachStr.indexOf(" ");
			if (start < 0) {
				return 0;
			}
			eachStr = eachStr.substring(start + 1);
			end = eachStr.indexOf("例");
			attrValue = IntX.str(eachStr.substring(0, end));
			break;
		case "city":
			try {
				attrValue = eachStr.substring(0, eachStr.indexOf(" "));
			} catch (Exception e) {
				e.printStackTrace();
			}
			attrValue = "";
			break;
		}
		return attrValue;
	}

}
