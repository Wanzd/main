package com.pd.it.model.system.menu;

import lombok.Data;

@Data
public class MenuVO {
	private String id;
	private String parentId;
	private String cn;
	private String en;
	private String url;
	private String detail;
}
