package com.pd.it.rest.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;
import com.pd.it.business.impl.JobBusiness;
import com.pd.it.business.impl.SariBusiness;
import com.pd.it.job.dao.IJobDao;
import com.pd.it.job.model.JobDTO;
import com.pd.it.job.model.JobFO;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.rest.api.IRest;

@RestController
@RequestMapping("/job")
public class JobRest implements IRest, IQueryRest<JobFO, JobDTO> {
	@Inject
	private JobBusiness business;

	@RequestMapping(value = "/parseToday")
	@ResponseBody
	public Object parseToday(@RequestBody(required = false) MapVO fo) {
		fo.put("creationDate", new Date());
		business.init(fo);
		business.process(fo);
		return 0;
	}
}
