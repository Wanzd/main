package com.pd.it.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;

/**
 * 房价应用
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("app/project")
public class ProjectRestService {

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "list")
	public Object list(PageFO pageFo) {
		return service.list(pageFo);
	}

	@RequestMapping(value = "report", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object report(@RequestBody FO fo) {
		return service.report(fo);
	}
}
