package com.pd.base.model;

import java.util.List;

import lombok.Data;

@Data
public class PagedResult<T> {
	private PageVO page;
	private List<T> list;
}
