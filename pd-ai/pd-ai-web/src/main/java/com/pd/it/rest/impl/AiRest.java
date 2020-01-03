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
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/ai")
public class AiRest {

	@RequestMapping(value = "/{domain}/{module}/{dimension}/{operation}")
	@ResponseBody
	public Object domain(@RequestBody MapVO fo, @PathVariable String domain, @PathVariable String module,
			@PathVariable String dimension, @PathVariable String operation) {
		ApplicationContext ctx = SpringUtil.getContext();
		ISystemMenuDao bean = ctx.getBean("ISystemMenuDao", ISystemMenuDao.class);
		return bean.queryList(null);
	}
}
