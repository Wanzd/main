package com.pd.base.model;

import lombok.Data;

@Data
public class PageVO {
	private int pageSize;
	private int curPage;
	private int mode;
	private int startIdx;
	private int endIdx;

	public int getStartIdx() {
		return pageSize * (curPage - 1) + 1;
	}

	public int getEndIdx() {
		return pageSize * curPage;
	}

}
