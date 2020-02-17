package com.pd.it.app.sari.builder;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.common.IntX;
import com.pd.it.common.ObjectX;
import com.pd.it.common.itf.IBuilder;

public class SariCityHtmlParseBuilder implements IBuilder<MapVO, List<MapVO>> {

	@Override
	public List<MapVO> build(MapVO in) {
		List<MapVO> rsList = new ArrayList<>();
		String inStr = in.str("value");
		String startStr = "<script id=\"js-initialData\" type=\"text/json\">";
		int start = inStr.indexOf(startStr);
		inStr = inStr.substring(start + startStr.length());
		int end = inStr.indexOf("</script>");
		inStr = inStr.substring(0, end);
		JSONObject jo = JSON.parseObject(inStr);
		JSONObject initialState = jo.getJSONObject("initialState");
		JSONObject nCoV2019 = initialState.getJSONObject("nCoV2019");
		JSONObject trends = nCoV2019.getJSONObject("trends");
		JSONArray domesticList = trends.getJSONArray("domesticList");
		String[] attrNames = new String[] { "cnt", "heal", "death", "doubt" };
		for (int provinceIdx = 0, provinceTotal = domesticList.size(); provinceIdx < provinceTotal; provinceIdx++) {
			JSONObject province = (JSONObject) domesticList.get(provinceIdx);
			String provinceName = province.getString("name").trim();
			JSONArray cities = province.getJSONArray("cities");
			for (int cityIdx = 0, cityTotal = cities.size(); cityIdx < cityTotal; cityIdx++) {
				JSONObject city = (JSONObject) cities.get(cityIdx);
				String cityName = city.getString("name").replace("市", "").trim();
				for (String eachAttrName : attrNames) {
					MapVO vo = new MapVO();
					vo.put("province", provinceName);
					vo.put("city", cityName);
					vo.put("qtyType", eachAttrName);
					vo.put("qty", parseAttr(eachAttrName, city));
					vo.put("creationDate", in.date("creationDate"));
					rsList.add(vo);
				}

			}
		}

		return rsList;
	}

	private Object parseAttr(String attrName, JSONObject city) {
		Object attrValue = null;
		int start = -1;
		int end = -1;
		switch (attrName) {
		case "death":
			attrValue = city.getIntValue("deathNum");
			break;
		case "heal":
			attrValue = city.getIntValue("cureNum");
			break;
		case "cnt":
			attrValue = city.getIntValue("conNum");
			break;
		}
		return attrValue;
	}

}