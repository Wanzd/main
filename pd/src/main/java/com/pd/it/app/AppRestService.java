package com.pd.it.app;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.app.economic.EconomicYearService;
import com.pd.it.app.job.service.JobCompanyService;
import com.pd.it.app.job.service.JobService;
import com.pd.it.app.job.service.JobTargetService;
import com.pd.it.app.job.task.JobDigService;
import com.pd.it.app.user.PersonRelationService;
import com.pd.it.common.itf.IDimensionRestService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/app")
public class AppRestService implements IDimensionRestService {
	@Autowired
	protected EconomicYearService economicYearService;
	@Inject
	protected PersonRelationService personRelationService;
	@Inject
	protected JobService jobService;
	@Inject
	protected JobDigService jobDigService;
	@Inject
	protected JobCompanyService jobCompany;
	@Inject
	protected JobTargetService jobTarget;

}
