package com.pd.it.module.todo;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.pd.it.common.vo.VO;
>>>>>>> branch 'dev_20190225' of https://github.com/Wanzd/main.git
import com.pd.it.web.itf.IQueryService;

@Service
public class TodoSuggestService implements IQueryService {

	@Inject
	protected ITodoDao dao;

}
