package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IMultyRouteService;

@Service
public class TodoService implements IMultyRouteService {

	@Autowired
	protected TodoSuggestService todoSuggest;
}
