package com.pd.it.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.SpringUtil;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.ResultVO;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/")
public class ReflectRestService {

	@ResponseBody
	@RequestMapping(value = "/ai", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object test(@RequestBody(required = false) FO in) {
		String serviceName = in.str("service");
		Object service = SpringUtil.getBean(serviceName);
		if (service == null) {
			return ResultVO.fail("Not support service!");
		}

		String methodName = in.str("method");
		Method method = Reflects.method(service, methodName);
		if (method == null) {
			return ResultVO.fail("Not support method!");
		}
		Object rsObj;
		try {
			rsObj = method.invoke(service, in.obj("data"));
			return ResultVO.json(rsObj);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			return ResultVO.error(e);
		}
	}
}
