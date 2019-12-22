package com.pd.ai.model;

import java.util.List;

import lombok.Data;

@Data
public class Axis {
	private String name;
	private List<String> values;

	public Axis(String name, List<String> values) {
		super();
		this.name = name;
		this.values = values;
	}

}
