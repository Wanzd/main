package com.pd.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SpringUtil implements ApplicationContextAware {
	private static ApplicationContext ctx;

	public static ModelAndView jsp(String url, Object... paramKv) {
		if (paramKv.length % 2 != 0) {
			return null;
		}
		ModelAndView mav = new ModelAndView(url);
		for (int i = 0, total = paramKv.length; i < total; i += 2) {
			mav.addObject(paramKv[i].toString(), paramKv[i + 1]);
		}
		return mav;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		if (SpringUtil.ctx == null) {
			SpringUtil.ctx = ctx;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
}
