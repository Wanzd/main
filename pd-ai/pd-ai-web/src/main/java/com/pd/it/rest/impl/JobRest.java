package com.pd.it.rest.impl;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.job.dao.IJobDao;
import com.pd.it.job.model.JobDTO;
import com.pd.it.job.model.JobFO;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.rest.api.IRest;

@RestController
@RequestMapping("/jobRest")
public class JobRest implements IRest, IQueryRest<JobFO, JobDTO> {
	@Inject
	private IJobDao dao;
}
