package com.pd.it.app.movie.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections4.ListUtils;

import com.pd.base.model.MapVO;
import com.pd.it.app.movie.builder.LvMovieHtmlParseBuilder;
import com.pd.it.app.movie.dao.ILvMovieDao;
import com.pd.it.base.WebUtil;
import com.pd.it.service.api.ITruncateService;

@Named
public class LvMovieService implements ITruncateService {

	@Inject
	private ILvMovieDao dao;

	public void process(MapVO fo) {
		parse(fo);
	}

	private void parse(MapVO fo) {
		LvMovieHtmlParseBuilder builder = new LvMovieHtmlParseBuilder();
		boolean activeFlag = true;
		int index = 1;
		while (activeFlag) {
			String indexUrl = (index == 1) ? "" : ("_" + index);
			String url = "https://2567lv.com/vod/html10/index" + indexUrl + ".html";
			index++;
			String httpStr = WebUtil.get(url, "utf-8");
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
