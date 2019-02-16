package com.pd.it.system.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.AI;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.web.itf.IMultyRouteService;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system/chartRest")
public class ChartRestService implements IMultyRouteService {

	@Autowired
	private ChartService service;

	@ResponseBody
	@RequestMapping(value = "/query/{id}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object queryChartConfig(@PathVariable("id") String id) {
		FO fo = new FO(AI.map("id", id));
		Object ra = service.query(fo);
		return X.jsonStr(ra);
	}

}
