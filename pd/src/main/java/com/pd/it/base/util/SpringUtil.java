package com.pd.it.base.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringUtil {

	public static <OUT> OUT method(String beanName, Class<OUT> clazz) {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		return (OUT) ac2.getBean(beanName);
	}

}
