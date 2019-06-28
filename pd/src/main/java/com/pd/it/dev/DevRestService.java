package com.pd.it.dev;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.dev.request.RequestService;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/dev")
public class DevRestService implements IDimensionRestService {

	@Inject
	protected RequestService request;
}
