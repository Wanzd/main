package com.pd.it.app.person;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pd.it.app.person.dao.IPersonBaseInfoDao;
import com.pd.it.app.person.dao.IPersonDao;
import com.pd.it.app.person.dao.IPersonRelationDao;
import com.pd.it.web.itf.service.ICommonService;

public class Person {
	@Service
	public static class PersonService implements ICommonService {

		@Inject
		protected IPersonDao dao;

	}

	@Service
	public static class PersonBaseInfoService implements ICommonService {

		@Inject
		protected IPersonBaseInfoDao dao;

	}

	@Service
	public static class PersonRelationService implements ICommonService {

		@Inject
		protected IPersonRelationDao dao;

		@Inject
		protected HttpServletResponse response;

		protected Class exportClass = PersonRelationExportVO.class;

	}
}
