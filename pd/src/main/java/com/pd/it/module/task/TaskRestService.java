package com.pd.it.module.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/taskRest")
public class TaskRestService {
	@Autowired
	private TaskService service;

	@ResponseBody
	@RequestMapping(value = "/execute", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object execute(@RequestBody(required = false) FO in) {
		Object ra = service.execute(in);
		return X.jsonStr(ra);
	}

}
