package com.pd.it.common.util;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.pd.it.common.vo.FO$page;
import com.pd.it.common.vo.VO;

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

	public static <Out> Out getBean(Class<Out> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public static <Out> Out getBean(String name, Class<Out> clazz) throws Exception {
		try {
			Object rs = getApplicationContext().getBean(name);
			return (Out) rs;
		} catch (Exception e) {
			return null;
		}
	}

	public static <In> Method getMethod(String action, Class<In> class1) {
		try {
			Method[] methods = class1.getDeclaredMethods();
			for (Method eachMethod : methods) {
				if (eachMethod.getName().equals(action)) {
					return eachMethod;
				}
			}
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * @ription 生成标准入参
	 * @param action
	 *            操作
	 * @param in
	 *            入参
	 * @return
	 */
	public static Object getParams(String action, LinkedHashMap<String, Object> in) {
		switch (action) {
		case "us":
		case "ds":
			VO vo = new VO(in);
			String object = vo.str("list");
			object = object.replaceAll("'", "''");
			List<VO> list = VO.list$str(object);
			return list;
		case "rs":
			FO$page fo$page = new FO$page();
			fo$page.setFo(in);
			return fo$page;
		case "ra":
			return in;
		default:
			return in;
		}
	}

	/**
	 * @Description 通过模块和维度查找服务名
	 *              <table border='1'>
	 *              <tr>
	 *              <td>module:模块名</td>
	 *              </tr>
	 *              </table>
	 * @param module
	 *            模块名
	 * @param dimension
	 *            维度名
	 * @return 服务名
	 */
	public static String getServiceName(String module, String dimension) {
		return module + X.str$cap(dimension) + "Service";
	}
}
