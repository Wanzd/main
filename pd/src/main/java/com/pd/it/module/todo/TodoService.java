package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.ICommonService;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class TodoService implements ICommonService {

	@Autowired
	protected ITodoDao dao;
}
