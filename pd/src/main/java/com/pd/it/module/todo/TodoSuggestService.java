package com.pd.it.module.todo;

import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IActionService;
import com.pd.it.common.vo.VO;

@Service
public class TodoSuggestService implements IActionService {

	@Override
	public Object query(VO vo) {
		return "todoSuggest_query:test";
	}

	@Override
	public Object update(VO vo) {
		return "todoSuggest_update:test";
	}

}
