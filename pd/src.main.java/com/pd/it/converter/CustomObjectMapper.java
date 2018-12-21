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
		//禁止使用时间戳
		this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		//设置为中国上海时区
		this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		//设置日期格式
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		//反序列化时，属性不存在的兼容处理  
		//this.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  
		//如果是空对象的时候,不抛异常
		//this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//反序列化的时候如果多了其他属性,不抛出异常
        //this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
        //单引号处理  
        //this.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true); 
	}
}
