package com.pd.it.system.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.app.datastage.IDataStageDao;
import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;
import com.pd.it.web.itf.service.IParallelService;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("app/dataStage")
public class AppDataStageService {

	@Inject
	private IDataStageDao dao;

	@ResponseBody
	@RequestMapping(value = "/{dimension}/task", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object task(@RequestBody(required = false) FO in, @PathVariable("dimension") String dimension) {
		IParallelService service = Reflects.field(this, IParallelService.class, dimension, dimension + "Service");
		Object ra = service.task(in);
		return StringX.json(ra);
	}

}
