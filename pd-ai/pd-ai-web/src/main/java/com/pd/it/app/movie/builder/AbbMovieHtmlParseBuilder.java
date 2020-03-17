package com.pd.it.app.movie.builder;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class AbbMovieHtmlParseBuilder implements IBuilder<String, List<MapVO>> {

	@Override
	public List<MapVO> build(String inStr) {
		List<MapVO> rsList = new ArrayList<>();
		Document doc = Jsoup.parse(inStr);
		Elements resultList = doc.getElementsByClass("listpic");
		resultList.forEach(eachVO -> {
			MapVO vo = new MapVO();
			String href = eachVO.getElementsByTag("a").first().attr("href");
			vo.put("id", href);
			vo.put("name", eachVO.getElementsByClass("vodname").first().text());
			vo.put("url", "https://19abb.com" + href);
			vo.put("source", "abb");
			rsList.add(vo);
		});

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
