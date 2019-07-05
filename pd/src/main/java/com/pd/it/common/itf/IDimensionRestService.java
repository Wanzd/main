package com.pd.it.common.itf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.base.util.Actions;
import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.PageVO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.web.itf.service.IExcelService;
import com.pd.it.web.itf.service.IParallelService;
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
public interface IDimensionRestService {

	@ResponseBody
	@RequestMapping(value = "/action/{dimension}/{action}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object doAction(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension,
			@PathVariable("action") String action) {
		IAction actionImpl = Actions.getAction(this, dimension, action);
		if (actionImpl == null) {
			return "Not support this service";
		}
		Object result = actionImpl.execute(in);
		return StringX.json(result);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object ra(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = null;
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/rs", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object rs(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = service.rs(in);
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/page", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object page(@RequestBody(required = false) PageFO in, @PathVariable("dimension") String dimension,
			@PathVariable PageVO page) {
		IQueryService service = Reflects.field(this, IQueryService.class, dimension, dimension + "Service");
		Object ra = service.page(in);
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/save", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object save(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		ISaveService service = Reflects.field(this, ISaveService.class, dimension, dimension + "Service");
		Object ra = service.batch(in);
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/importExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default void importExcel(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IExcelService service = Reflects.field(this, IExcelService.class, dimension, dimension + "Service");
		service.importExcel(in);
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/exportExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object exportExcel(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IExcelService service = Reflects.field(this, IExcelService.class, dimension, dimension + "Service");
		service.exportExcel(in);
		return StringX.json(ResultVO.success("export success!"));
	}

	@ResponseBody
	@RequestMapping(value = "/{dimension}/task", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object task(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IParallelService service = Reflects.field(this, IParallelService.class, dimension, dimension + "Service");
		Object ra = service.task(in);
		return StringX.json(ra);
	}
}
