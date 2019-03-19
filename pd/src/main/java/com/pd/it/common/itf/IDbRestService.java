package com.pd.it.common.itf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.ResultVO;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
@RestController
public interface IDbRestService {

	@ResponseBody
	@RequestMapping(value = "/{dimension}/{action}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object operate(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension,
			@PathVariable("action") String action) {

		try {
			ICommonDbService service = Reflects.field(this, ICommonDbService.class, dimension, dimension + "Service");
			Method method = Reflects.method(service, action);
			Object invokeRs = method.invoke(service, in);
			return StringX.json(invokeRs);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			ResultVO.error(e);
		}
		return ResultVO.error("not impl yet!");
	}
}
