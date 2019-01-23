package com.pd.it.module.task;

import org.springframework.stereotype.Service;

import com.pd.it.common.util.Valids;
import com.pd.it.common.vo.FO;

@Service("taskService")
public class TaskService {

	public Object execute(FO in) {
		return Valids.error("Not Support task");
	}

}
