package com.pd.ai.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 此处的Application.class为带有@SpringBootApplication注解的启动类
		return builder.sources(Application.class);
	}

}
