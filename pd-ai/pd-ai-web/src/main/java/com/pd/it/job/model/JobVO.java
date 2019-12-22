package com.pd.it.job.model;

import lombok.Data;

@Data
public class JobVO {
	private String id;
	private String job;
	private String company;
	private String salary;
	private String salryFrom;
	private String salaryTo;
	private String location;
}
