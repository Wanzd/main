package com.pd.it.web.itf.service;

public interface IService {
	default Object query(Object in) {
		return null;
	}
}
