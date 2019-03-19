package com.pd.it.common.util;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;
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

	public static <Out> Out getBean(String name, Class<Out> clazz) {
		try {
			Object rs = getApplicationContext().getBean(name);
			return (Out) rs;
		} catch (Exception e) {
			return null;
		}
	}

	public static <In> Method getMethod(String action, Class<In> class1) {
		try {
			Method[] methods = class1.getMethods();
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
	 * @ription ���ɱ�׼���
	 * @param action
	 *            ����
	 * @param in
	 *            ���
	 * @return
	 */
	public static Object getParams(String action, LinkedHashMap<String, Object> in) {
		Object rs = null;
		switch (action) {
		case "us":
			VO usVO = new VO(in);
			String usList = usVO.str("list");
			usList = usList.replaceAll("'", "''");
			rs = VO.list$str(usList);
			break;
		case "ds":
			VO dsVO = new VO(in);
			String dsList = dsVO.str("list");
			dsList = dsList.replaceAll("'", "''");
			List<VO> list = VO.list$str(dsList);
			break;
		case "rs":
			PageFO fo$page = new PageFO();
			fo$page.setFo(new FO(in));
			return fo$page;
		case "ra":
			FO inVO = new FO(in);
			return inVO;
		default:
			return in;
		}
		return rs;
	}

	/**
	 * @Description ͨ��ģ���ά�Ȳ��ҷ�����
	 *              <table border='1'>
	 *              <tr>
	 *              <td>module:ģ����</td>
	 *              </tr>
	 *              </table>
	 * @param module
	 *            ģ����
	 * @param dimension
	 *            ά����
	 * @return ������
	 */
	public static String getServiceName(String module, String dimension) {
		return module + StringX.cap(dimension) + "Service";
	}
}
