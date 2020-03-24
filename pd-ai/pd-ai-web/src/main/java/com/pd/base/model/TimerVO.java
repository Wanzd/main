package com.pd.base.model;

import java.util.Date;

public class TimerVO {
	private Date start;
	private Date end;
	private String name;

	public TimerVO(String name) {
		this.name = name;
		this.start = new Date();
	}

	public String end() {
		end = new Date();
		long useTime = end.getTime() - start.getTime();
		return String.format("%s end: use time %dms.", name, useTime);
	}
}
