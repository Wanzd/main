package com.pd.it.rest.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.ai.dao.ISystemMenuDao;
import com.pd.base.model.MapVO;
import com.pd.it.common.SpringUtil;

/**
 * 桥接到其它服务器的简单服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/bids")
public class BidsRest {

	@RequestMapping(value = "/{taskId}")
	@ResponseBody
	public Object queryList(@RequestBody MapVO fo, @PathVariable("taskId") String taskId) {
		ApplicationContext ctx = SpringUtil.getContext();
		ISystemMenuDao bean = ctx.getBean("ISystemMenuDao", ISystemMenuDao.class);
		return bean.queryList(null);
	}
}
