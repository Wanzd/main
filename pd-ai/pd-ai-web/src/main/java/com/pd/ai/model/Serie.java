package com.pd.ai.model;

import java.util.List;

import lombok.Data;

@Data
public class Serie {
	private String name;
	private List<Double> data;

	public Serie(String name, List<Double> data) {
		super();
		this.name = name;
		this.data = data;
	}

}
