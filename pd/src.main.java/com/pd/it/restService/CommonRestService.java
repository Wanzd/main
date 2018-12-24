package com.pd.it.restService;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.exception.WebError.NoServiceException;
import com.pd.it.common.exception.WebError.NoMethodException;
import com.pd.it.common.exception.WebError.NoParamsException;
import com.pd.it.common.itf.IDbService;
import com.pd.it.common.util.SpringUtil;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("common")
public class CommonRestService {

	@ResponseBody
	@RequestMapping(value = "{action}/{module}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			@RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json) {
		return rest(action, module, "", in, json);
	}

	@ResponseBody
	@RequestMapping(value = "{action}/{module}/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			@PathVariable("dimension") String dimension, @RequestParam LinkedHashMap<String, Object> in,
			LinkedHashMap<String, String> json) {
		try {
			String serviceName = SpringUtil.getServiceName(module, dimension);
			IDbService service = SpringUtil.getBean(serviceName, IDbService.class);

			Method method = SpringUtil.getMethod(action, IDbService.class);
			Object params = SpringUtil.getParams(action, in);
			Object rs = method.invoke(service, params);
			return X.jsonStr(rs);
		} catch (Exception e) {
			return X.jsonStr(ResultVO.error(e));
		}
	}

}
