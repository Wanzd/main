package com.pd.it.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.it.app.job.service.Job51Service;

@Named
public class JobBusiness {
	@Inject
	private Job51Service service;

	public void init(MapVO fo) {
		service.init(fo);
	}

	public void process(MapVO fo) {
		service.process(fo);
	}

}
