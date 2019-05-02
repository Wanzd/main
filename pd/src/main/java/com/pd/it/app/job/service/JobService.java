package com.pd.it.app.job.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;


import com.pd.it.app.job.dao.IAppJobDao;
import com.pd.it.app.job.vo.JobCompanyExportVO;
import com.pd.it.web.itf.service.IExcelService;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class JobService implements IQueryService, IExcelService {

	@Inject
	protected IAppJobDao dao;
	@Inject
	protected HttpServletResponse response;

	protected Class exportClass = JobCompanyExportVO.class;

}