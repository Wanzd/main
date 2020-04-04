package com.pd.it.task.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import com.pd.base.model.MapVO;
import com.pd.base.model.TimerVO;
import com.pd.it.business.impl.JobBusiness;
import com.pd.it.task.api.ITask;

@Named(JobInfoParseTodayTask.TITLE)
public class JobInfoParseTodayTask implements ITask {
	public static final String TITLE = "jobInfoParseTodayTask";
	@Inject
	private JobBusiness business;

	@Override
	public Object process() {
		TimerVO timer = new TimerVO(TITLE);
		MapVO fo = new MapVO();
		fo.put("creationDate", new Date());
		business.init(fo);
		business.process(fo);
		return timer.end();
	}
}
