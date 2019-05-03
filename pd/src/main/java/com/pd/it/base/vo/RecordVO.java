package com.pd.it.base.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pd.it.base.converter.CustomDateSerializer;

public class RecordVO {
	private String createdBy;
	private String createdName;
	private Date creationDate;
	private String lastUpdatedBy;
	private String lastUpdatedName;
	private Date lastUpdateDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedName() {
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedName() {
		return lastUpdatedName;
	}

	public void setLastUpdatedName(String lastUpdatedName) {
		this.lastUpdatedName = lastUpdatedName;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
