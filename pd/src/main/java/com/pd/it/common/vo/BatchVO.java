package com.pd.it.common.vo;

import java.util.List;

import lombok.Data;

@Data
public class BatchVO<Vo> {
	private List<Vo> items2Create;
	private List<Vo> items2Update;
	private List<Vo> items2Delete;

}
