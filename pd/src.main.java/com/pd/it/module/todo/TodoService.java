package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.VO;

@Service("todoService")
public class TodoService implements IDbService<VO, VO, VO, ITodoDao> {

	@Autowired
	private ITodoDao dao;

	@Override
	public ITodoDao getDao() {
		return dao;
	}

}
