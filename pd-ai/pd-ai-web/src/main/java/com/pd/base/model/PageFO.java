package com.pd.base.model;

import lombok.Data;

@Data
public class PageFO {
	private FilterObject fo;
	private PageVO page = new PageVO();
}
