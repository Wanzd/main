package com.pd.it.common.itf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.PageVO;
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
public interface IDimensionRestService{

	@ResponseBody
	@RequestMapping(value = "/{dimension}/r", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object r(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = service.r(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object ra(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = service.ra(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/page", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object page(@RequestBody(required = false) PageFO in, @PathVariable("dimension") String dimension,
			@PathVariable PageVO page) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = service.page(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/update", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		ISaveService service = Reflects.field(this, ISaveService.class, dimension, dimension + "Service");
		Object ra = service.update(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/importExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object importExcel(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IExcelService service = Reflects.field(this, IExcelService.class, dimension, dimension + "Service");
		Object ra = service.importExcel(in);
		return X.jsonStr(ra);
	}
}
