package com.pd.it.app.ecnomic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.web.itf.IMultyRouteService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/app/ecnomicRest")
public class EcnomicRestService implements IMultyRouteService {
	@Autowired
	protected EcnomicYearService year;

}
