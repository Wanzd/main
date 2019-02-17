package com.pd.it.converter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomObjectMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2607542031146051224L;

	public CustomObjectMapper() {
		this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

	}
}
