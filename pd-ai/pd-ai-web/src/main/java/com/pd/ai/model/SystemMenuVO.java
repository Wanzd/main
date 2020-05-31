package com.pd.ai.model;

import lombok.Data;

@Data
public class SystemMenuVO extends PdBaseVO {
	private String parentId;
	private String id;
	private String cn;
	private String en;
	private String url;
	private String detail;
}
