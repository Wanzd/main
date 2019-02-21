package com.pd.it.module.todo.waiting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IDbDimensionService;

@Service("todoWaitingService")
public class TodoWaitingService implements IDbDimensionService<ITodoWaitingDao> {

	@Autowired
	private ITodoWaitingDao dao;

	@Override
	public ITodoWaitingDao getDao() {
		return dao;
	}

}
