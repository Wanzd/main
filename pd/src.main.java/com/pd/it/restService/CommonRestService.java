package com.pd.it.restService;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO$page;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;
import com.pd.web.util.SpringUtil;

@RestController
@RequestMapping("common")
public class CommonRestService {

	@ResponseBody
	@RequestMapping(value = "{action}/{module}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			LinkedHashMap<String, String> json) {
		return rest(action, module, "", json);
	}

	@ResponseBody
	@RequestMapping(value = "{action}/{module}/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			@PathVariable("dimension") String dimension, LinkedHashMap<String, String> json) {
		try {
			IDbService dbService = getService(module, dimension);
			Method method = getMethod(action);
			Object params = getParams(action, json);
			Object rs = method.invoke(dbService, params);
			return X.jsonStr(ResultVO.success(rs));
		} catch (Exception e) {
			return X.jsonStr(ResultVO.error(e));
		}
	}

	private IDbService getService(String module, String dimension) {
		Object service = SpringUtil.getBean(module + dimension + "Service");
		IDbService dbService = (IDbService) service;
		return dbService;
	}

	private Method getMethod(String action) {
		Method[] methods = IDbService.class.getDeclaredMethods();
		for (Method eachMethod : methods) {
			if (eachMethod.getName().equals(action)) {
				return eachMethod;
			}
		}
		return null;
	}

	private Object getParams(String action, LinkedHashMap<String, String> json) {
		switch (action) {
		case "ds":
			VO vo = new VO(json);
			String object = vo.str("list");
			object = object.replaceAll("'", "''");
			List<VO> list = VO.list$str(object);
			return list;
		case "rs":
			return new FO$page();
		}
		return null;
	}
}
