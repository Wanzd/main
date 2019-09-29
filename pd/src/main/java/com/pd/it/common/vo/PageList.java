package com.pd.it.common.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PageList<VO> extends ArrayList<VO> {
	private static final long serialVersionUID = 9034138639691681290L;

	private PageVO page;

}
