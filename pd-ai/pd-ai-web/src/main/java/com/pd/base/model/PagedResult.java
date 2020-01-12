package com.pd.base.model;

import java.util.List;

import lombok.Data;

@Data
public class PagedResult<DTO> {

	public PagedResult(List<DTO> list, PageVO page) {
		this.page=page;
		this.list=list;
	}

	private PageVO page;
	private List<DTO> list;
}
