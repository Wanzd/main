package com.pd.it.app.job.vo;

import com.pd.it.common.annotation.ExcelCol;
import com.pd.it.common.annotation.ExcelSheet;

@ExcelSheet(sheetName = "工作信息")
public class JobExportVO {
	@ExcelCol("工作岗位")
	private String job;

	@ExcelCol("公司名称")
	private String company;

	@ExcelCol("工资")
	private String salary;

	@ExcelCol("最低工资")
	private String salaryStart;

	@ExcelCol("最高工资")
	private String salaryEnd;

	@ExcelCol("发布时间")
	private String createDate;

	@ExcelCol("详细地址")
	private String url;

	@ExcelCol("详情")
	private String detail;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSalaryStart() {
		return salaryStart;
	}

	public void setSalaryStart(String salaryStart) {
		this.salaryStart = salaryStart;
	}

	public String getSalaryEnd() {
		return salaryEnd;
	}

	public void setSalaryEnd(String salaryEnd) {
		this.salaryEnd = salaryEnd;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
