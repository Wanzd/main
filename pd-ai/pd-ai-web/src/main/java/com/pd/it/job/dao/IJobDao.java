package com.pd.it.job.dao;

import org.springframework.stereotype.Repository;

import com.pd.it.dao.api.IDao;

@Repository
public interface IJobDao<JobVO, JobFO, JobDTO> extends IDao<JobVO, JobFO, JobDTO> {
}