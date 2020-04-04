package com.pd.it.task.impl;

import javax.inject.Named;

import com.pd.base.model.TimerVO;
import com.pd.it.task.api.ITask;

@Named(NationPersonCount2020Task.TITLE)
public class NationPersonCount2020Task implements ITask {
	public final static String TITLE = "nationPersonCount2020";

	@Override
	public Object process() {
		TimerVO timer = new TimerVO(TITLE);
		return timer.end();
	}
}
