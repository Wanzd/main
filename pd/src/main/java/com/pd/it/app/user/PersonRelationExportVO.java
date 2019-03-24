package com.pd.it.app.user;

import com.pd.it.common.annotation.ExcelCol;
import com.pd.it.common.annotation.ExcelSheet;

@ExcelSheet(sheetName = "人员关系")
public class PersonRelationExportVO {
	@ExcelCol("关系来源人")
	private String fromPerson;

	@ExcelCol("关系目标人")
	private String toPerson;

	@ExcelCol("关系名称")
	private String relTag;

	public String getFromPerson() {
		return fromPerson;
	}

	public void setFromPerson(String fromPerson) {
		this.fromPerson = fromPerson;
	}

	public String getToPerson() {
		return toPerson;
	}

	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}

	public String getRelTag() {
		return relTag;
	}

	public void setRelTag(String relTag) {
		this.relTag = relTag;
	}
}

