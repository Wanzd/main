package com.pd.it.module.todo.waiting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.VO;

@Service("todoWaitingService")
public class TodoWaitingService implements IDbService<VO, VO, VO, ITodoWaitingDao> {

	@Autowired
	private ITodoWaitingDao dao;

	@Override
	public ITodoWaitingDao getDao() {
		return dao;
	}

}
