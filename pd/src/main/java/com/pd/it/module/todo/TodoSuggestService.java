package com.pd.it.module.todo;

import org.springframework.stereotype.Service;

import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IQueryDimensionService;

@Service
public class TodoSuggestService implements IQueryDimensionService {

	@Override
	public Object validQuery(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeQuery(VO vo) {
		return "todoSuggest_query:test";
	}

}
