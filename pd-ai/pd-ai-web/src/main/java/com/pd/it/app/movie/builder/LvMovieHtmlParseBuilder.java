package com.pd.it.app.movie.builder;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.pd.base.model.MapVO;
import com.pd.it.common.itf.IBuilder;

public class LvMovieHtmlParseBuilder implements IBuilder<String, List<MapVO>> {

	@Override
	public List<MapVO> build(String inStr) {
		List<MapVO> rsList = new ArrayList<>();
		Document doc = Jsoup.parse(inStr);
		Elements resultList = doc.getElementsByClass("text-overflow");
		resultList.forEach(eachVO -> {
			if (!eachVO.tag().getName().equals("h5")) {
				return;
			}
			MapVO vo = new MapVO();
			String href = eachVO.getElementsByTag("a").first().attr("href");
			vo.put("id", href);
			vo.put("name", eachVO.getElementsByTag("a").first().text());
			vo.put("url", "https://2567lv.com" + href);
			vo.put("source", "lv");
			rsList.add(vo);
		});

		return rsList;
	}

}
