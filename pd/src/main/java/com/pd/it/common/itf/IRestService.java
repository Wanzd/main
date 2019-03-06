package com.pd.it.common.itf;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.web.itf.IQueryDimensionService;
import com.pd.it.web.itf.IUpdateDimensionService;

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
public interface IRestService {

	@ResponseBody
	@RequestMapping(value = "/query", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object query(@RequestBody(required = false) FO in) {
		IQueryDimensionService service = Reflects.field(this, "service");
		Object ra = service.query(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in) {
		IUpdateDimensionService service = Reflects.field(this, "service");
		Object ra = service.update(in);
		return X.jsonStr(ra);
	}
}
