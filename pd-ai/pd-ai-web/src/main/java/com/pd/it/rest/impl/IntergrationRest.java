package com.pd.it.rest.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.SpringUtil;
import com.pd.it.task.api.ITask;

/**
 * 集成系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/intergrationRest")
public class IntergrationRest {
	@RequestMapping(value = "/{taskName}")
	@ResponseBody
	public Object intergration(@PathVariable String taskName) {
		ITask task = SpringUtil.getBean(taskName, ITask.class);
		if (task == null) {
			return "not impl task:" + taskName;
		}
		return task.process();
	}

}
