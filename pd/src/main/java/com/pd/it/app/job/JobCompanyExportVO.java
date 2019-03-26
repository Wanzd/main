package com.pd.it.app.job;

import com.pd.it.common.annotation.ExcelCol;
import com.pd.it.common.annotation.ExcelSheet;

@ExcelSheet(sheetName = "工作公司")
public class JobCompanyExportVO {
	@ExcelCol("公司")
	private String company;

	@ExcelCol("平均工资")
	private String salaryAvg;

	@ExcelCol("最高工资")
	private String salaryMax;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalaryAvg() {
		return salaryAvg;
	}

	public void setSalaryAvg(String salaryAvg) {
		this.salaryAvg = salaryAvg;
	}

	public String getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(String salaryMax) {
		this.salaryMax = salaryMax;
	}
}
