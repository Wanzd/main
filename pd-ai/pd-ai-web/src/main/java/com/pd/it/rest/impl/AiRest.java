package com.pd.it.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.StringX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.dao.api.IQueryDao;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/ai")
public class AiRest {
	private Map<String, IBuilder> builderMap = initBuilderMap();

	@RequestMapping(value = "/{domain}/{module}/{dimension}/{operation}", produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public Object domain(@RequestBody(required = false) MapVO fo, @PathVariable String domain,
			@PathVariable String module, @PathVariable String dimension, @PathVariable String operation) {
		if (fo == null) {
			fo = new MapVO();
		}
		fo.put("domain", domain);
		fo.put("module", module.equals("default") ? "" : module);
		fo.put("dimension", dimension.equals("default") ? "" : dimension);
		String beanName = "I"+StringX.cap(fo.str("domain")) + StringX.cap(fo.str("module"))
				+ StringX.cap(fo.str("dimension")+"Dao");
		fo.put("beanName", beanName);
		
		IBuilder<Object, Object> opBuilder = builderMap.get(operation);
		return opBuilder.build(fo);
	}

	@RequestMapping(value = "/{dimension}/{operation}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object dimension(@RequestBody(required = false) MapVO fo, @PathVariable String dimension,
			@PathVariable String operation) {
		if (fo == null) {
			fo = new MapVO();
		}
		fo.put("beanName", dimension.equals("default") ? "" : dimension);

		IBuilder<Object, Object> opBuilder = builderMap.get(operation);
		return opBuilder.build(fo);
	}

	/**
	 * 初始化执行器地图
	 * 
	 * @return
	 */
	private Map<String, IBuilder> initBuilderMap() {
		Map<String, IBuilder> opMap = new HashMap<>();
		opMap.put("init", new IInitOperationBuilder());
		opMap.put("query", new IQueryOperationBuilder());
		opMap.put("queryList", new IQueryListOperationBuilder());
		opMap.put("queryPagedList", new IQueryPagedListOperationBuilder());
		return opMap;
	}
}
