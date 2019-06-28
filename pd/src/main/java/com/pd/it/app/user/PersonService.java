package com.pd.it.app.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.ICommonService;

@Service
public class PersonService implements ICommonService {

	@Inject
	protected IPersonDao dao;

}
