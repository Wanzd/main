package com.pd.it.app.sari.builder;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class SariNationHtmlParseBuilder implements IBuilder<MapVO, List<MapVO>> {

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
		JSONArray overseasList = trends.getJSONArray("overseasList");
		String[] attrNames = new String[] { "cnt", "heal", "death", "doubt" };
		for (int nationIdx = 0, provinceTotal = overseasList.size(); nationIdx < provinceTotal; nationIdx++) {
			JSONObject nation = (JSONObject) overseasList.get(nationIdx);
			String nationName = nation.getString("name").trim();
			for (String eachAttrName : attrNames) {
				MapVO vo = new MapVO();
				vo.put("nation", nationName);
				vo.put("qtyType", eachAttrName);
				vo.put("qty", parseAttr(eachAttrName, nation));
				vo.put("creationDate", in.date("creationDate"));
				rsList.add(vo);

			}
		}

		return rsList;
	}

	private Object parseAttr(String attrName, JSONObject nation) {
		Object attrValue = null;
		int start = -1;
		int end = -1;
		switch (attrName) {
		case "death":
			attrValue = nation.getIntValue("deathNum");
			break;
		case "heal":
			attrValue = nation.getIntValue("cureNum");
			break;
		case "cnt":
			attrValue = nation.getIntValue("conNum");
			break;
		}
		return attrValue;
	}

}