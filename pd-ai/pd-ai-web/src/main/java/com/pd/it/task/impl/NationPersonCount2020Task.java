package com.pd.it.task.impl;

import javax.inject.Named;

import com.pd.it.task.api.ITask;

@Named("nationPersonCount2020")
public class NationPersonCount2020Task implements ITask {

	@Override
	public Object process() {
		return "nationPersonCount2020";
	}
}
