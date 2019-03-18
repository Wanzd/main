package com.pd.it.module.todo.waiting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;

@Service
public class TodoWaitingService implements IQueryService {

	@Autowired
	protected ITodoWaitingDao dao;

}
