package com.pd.it.app.job;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IExcelService;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class JobCompanyService implements IQueryService, IExcelService {

	@Inject
	protected IAppJobCompanyDao dao;
	@Inject
	protected HttpServletResponse response;

	protected Class exportClass = JobCompanyExportVO.class;

}