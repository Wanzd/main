package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.ISimpleDbService;
import com.pd.it.common.vo.VO;

@Service("todoService")
public class TodoService implements ISimpleDbService<VO, ITodoDao> {

	@Autowired
	private ITodoDao dao;

	@Override
	public ITodoDao getDao() {
		return dao;
	}

}
