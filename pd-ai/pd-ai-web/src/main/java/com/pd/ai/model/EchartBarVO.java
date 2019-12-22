package com.pd.ai.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EchartBarVO {
	private String title;
	private String subTitle;
	private List<String> legend;
	private List<String> xaxis;
	private List<Serie> series;

	public void addSerie(Serie serie) {
		if (series == null) {
			series = new ArrayList<>();
		}
		series.add(serie);
	}

	public void addSerie(String name, List<Double> valueList) {
		addSerie(new BarSerie(name, valueList));
	}
}
