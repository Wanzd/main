package com.pd.ai.model;

import java.util.List;

import lombok.Data;

@Data
public class BarSerie extends Serie {
	private String type = "bar";

	public BarSerie(String name, List<Double> valueList) {
		super(name, valueList);
	}

}
