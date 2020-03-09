package com.pd.it.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		ctx = applicationContext;
	}

	public static ApplicationContext getContext() {
		return ctx;
	}

	public static <T> T getBean(String beanName, Class<T> className) {
		return ctx.getBean(beanName, className);
	}
}
