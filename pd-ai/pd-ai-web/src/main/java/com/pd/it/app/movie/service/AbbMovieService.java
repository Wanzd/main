package com.pd.it.app.movie.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.ListUtils;

import com.pd.base.model.MapVO;
import com.pd.it.app.movie.builder.AbbMovieHtmlParseBuilder;
import com.pd.it.app.movie.dao.IAbbMovieDao;
import com.pd.it.base.WebUtil;
import com.pd.it.service.api.ITruncateService;

@Named
public class AbbMovieService implements ITruncateService {

	@Inject
	private IAbbMovieDao dao;

	public void process(MapVO fo) {
		parse(fo);
	}

	private void parse(MapVO fo) {
		AbbMovieHtmlParseBuilder builder = new AbbMovieHtmlParseBuilder();
		boolean activeFlag = true;
		int index = 1;
		while (activeFlag) {
			String indexUrl = (index == 1) ? "" : ("_" + index);
			String url = "https://19abb.com/html/vodlist/728" + indexUrl + ".html";
			index++;
			String httpStr = WebUtil.post(url, null);
			if (httpStr.length() == 0) {
				activeFlag = false;
				break;
			}
			List<MapVO> list = builder.build(httpStr);
			insertList(list);
		}
	}

	private void insertList(List<MapVO> map) {
		MapVO dto = new MapVO();
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
