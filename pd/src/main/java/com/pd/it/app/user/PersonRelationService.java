package com.pd.it.app.user;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.ICommonService;

@Service
public class PersonRelationService implements ICommonService {

	@Inject
	protected IPersonRelationDao dao;

	@Inject
	protected HttpServletResponse response;

	protected Class exportClass = PersonRelationExportVO.class;

}
