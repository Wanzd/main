package com.pd.it.common.vo;

import java.util.List;

public class BatchVO<Vo> {
	private List<Vo> items2Create;

	private List<Vo> items2Update;

	private List<Vo> items2Delete;

	public List<Vo> getItems2Create() {
		return items2Create;
	}

	public void setItems2Create(List<Vo> items2Create) {
		this.items2Create = items2Create;
	}

	public List<Vo> getItems2Update() {
		return items2Update;
	}

	public void setItems2Update(List<Vo> items2Update) {
		this.items2Update = items2Update;
	}

	public List<Vo> getItems2Delete() {
		return items2Delete;
	}

	public void setItems2Delete(List<Vo> items2Delete) {
		this.items2Delete = items2Delete;
	}

}
