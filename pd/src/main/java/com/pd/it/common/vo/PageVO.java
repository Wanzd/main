package com.pd.it.common.vo;

public class PageVO {
	private int pageSize;
	private int curPage;
	private int mode;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getStartIdx() {
		return pageSize * (curPage - 1) + 1;
	}

	public int getEndIdx() {
		return pageSize * curPage;
	}

}
