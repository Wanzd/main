package com.pd.it.movie.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.app.movie.service.AbbMovieService;
import com.pd.it.app.movie.service.LvMovieService;

@Named
public class MovieBusiness {
	@Inject
	private AbbMovieService abb;
	@Inject
	private LvMovieService lv;

	public void process(MapVO fo) {
		lv.process(fo);
		abb.process(fo);
	}

}
