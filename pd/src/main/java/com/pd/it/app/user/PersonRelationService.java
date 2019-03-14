package com.pd.it.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IQueryService;

@Service
public class PersonRelationService implements IQueryService {

	@Autowired
	protected IPersonRelationDao dao;

}
