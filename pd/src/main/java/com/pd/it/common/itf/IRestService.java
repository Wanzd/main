package com.pd.it.common.itf;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;
import com.pd.it.web.itf.service.IExcelService;
import com.pd.it.web.itf.service.IQueryService;
import com.pd.it.web.itf.service.ISaveService;

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
	@RequestMapping(value = "/r", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object r(@RequestBody(required = false) FO in) {
		IQueryService service = Reflects.field(this, IQueryService.class, "service");
		// Object ra = service.r(in);
		Object ra = null;
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object ra(@RequestBody(required = false) FO in) {
		IQueryService service = Reflects.field(this, IQueryService.class, "service");
		// Object ra = service.ra(in);
		Object ra = null;
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/batch", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object batch(@RequestBody(required = false) FO in) {
		ISaveService service = Reflects.field(this, ISaveService.class, "service");
		Object ra = service.batch(in);
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/importExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object importExcel(@RequestBody(required = false) FO in) {
		IExcelService service = Reflects.field(this, IExcelService.class, "service");
		Object ra = service.importExcel(in);
		return StringX.json(ra);
	}
}
