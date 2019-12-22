package com.pd.it.job.model;

import lombok.Data;

@Data
public class JobVO {
	private String id;
	private String job;
	private String company;
	private String salary;
	private Double salaryFrom;
	private Double salaryTo;
	private String location;
}
