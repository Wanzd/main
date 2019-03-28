package com.pd.it.app.job.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.app.job.dao.IAppJobTargetDao;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class JobTargetService implements IQueryService {

	@Inject
	protected IAppJobTargetDao dao;

}