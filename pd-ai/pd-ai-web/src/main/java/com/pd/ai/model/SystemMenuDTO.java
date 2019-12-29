package com.pd.ai.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemMenuDTO extends SystemMenuVO {
	private String text;

	public void setCn(String cn) {
		super.setCn(cn);
		text=cn;
	}
}
