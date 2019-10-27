package com.pd.ai.model;

import lombok.Data;

@Data
public class SystemMenuVO {
	private String id;
	private String parentId;
	private String cn;
	private String en;
	private String url;
	private String detail;
}
