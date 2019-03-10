package com.pd.it.common.itf;

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
public interface IRestService {

	@ResponseBody
	@RequestMapping(value = "/r", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
<<<<<<< HEAD
	default Object r(@RequestBody(required = false) FO in) {
		IQueryService service = Reflects.field(this, "service");
		Object ra = service.r(in);
=======
	default Object query(@RequestBody(required = false) FO in) {
		IQueryService service = Reflects.field(this, "service");
		Object ra = service.query(in);
>>>>>>> branch 'dev_20190225' of https://github.com/Wanzd/main.git
		return X.jsonStr(ra);
	}

	@ResponseBody
<<<<<<< HEAD
	@RequestMapping(value = "/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object ra(@RequestBody(required = false) FO in) {
		IQueryService service = Reflects.field(this, "service");
		Object ra = service.ra(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
=======
>>>>>>> branch 'dev_20190225' of https://github.com/Wanzd/main.git
	@RequestMapping(value = "/update", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in) {
		IUpdateService service = Reflects.field(this, "service");
		Object ra = service.update(in);
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/importExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object importExcel(@RequestBody(required = false) FO in) {
		IImportExcelService service = Reflects.field(this, "service");
		Object ra = service.importExcel(in);
		return X.jsonStr(ra);
	}
}
