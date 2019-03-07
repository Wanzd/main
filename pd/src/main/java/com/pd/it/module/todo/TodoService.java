package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IQueryService;

@Service
public class TodoService implements IQueryService {

	@Autowired
	protected ITodoDao dao;
}
