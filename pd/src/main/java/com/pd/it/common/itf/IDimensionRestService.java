package com.pd.it.common.itf;

<<<<<<< HEAD
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
import com.pd.it.web.itf.IImportExcelService;
import com.pd.it.web.itf.IQueryService;
import com.pd.it.web.itf.IUpdateService;

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
public interface IDimensionRestService {

	@ResponseBody
	@RequestMapping(value = "/{dimension}/r", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object r(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, dimension + "Service");
		Object ra = service.r(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object ra(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, dimension + "Service");
		Object ra = service.ra(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/page", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object page(@RequestBody(required = false) PageFO in, @PathVariable("dimension") String dimension,
			@PathVariable PageVO page) {
		IQueryService service = Reflects.field(this, dimension + "Service");
		Object ra = service.page(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/update/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IUpdateService service = Reflects.field(this, dimension + "Service");
		Object ra = service.update(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/importExcel/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object importExcel(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.web.itf.IImportExcelService;
import com.pd.it.web.itf.IQueryService;
import com.pd.it.web.itf.IUpdateService;

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
public interface IDimensionRestService {

	@ResponseBody
	@RequestMapping(value = "/query/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object query(@RequestBody(required = false) FO in, String dimension) {
		IQueryService service = Reflects.field(this, dimension + "Service");
		Object ra = service.query(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/update/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in, String dimension) {
		IUpdateService service = Reflects.field(this, dimension + "Service");
		Object ra = service.update(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/importExcel/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object importExcel(@RequestBody(required = false) FO in, String dimension) {
>>>>>>> branch 'dev_20190225' of https://github.com/Wanzd/main.git
		IImportExcelService service = Reflects.field(this, dimension + "Service");
		Object ra = service.importExcel(in);
		return X.jsonStr(ra);
	}
}
