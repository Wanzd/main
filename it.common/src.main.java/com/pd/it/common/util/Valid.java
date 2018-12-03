package com.pd.it.common.util;

import com.pd.it.common.itf.IValidRule;

public class Valid {
	public static boolean eq(Object o1, Object o2) {
		if (o1 == null && o2 == null) {
			return true;
		}
		if ((o1 == null && o2 != null) || (o1 != null && o2 == null)) {
			return false;
		}
		if (o1 == o2) {
			return true;
		}
		if (o1.equals(o2)) {
			return true;
		}
		return false;
	}

	public static <In> boolean valid(Class<In> inClass, In in, String beansStr) {
		String[] beans = beansStr.split(",");
		for (String eachBeanName : beans) {
			boolean capFlag = Valid.eq("!", eachBeanName.substring(0, 1));
			if (capFlag) {
				eachBeanName = eachBeanName.substring(1);
			}
			IValidRule<In> validRule = BeanUtil.<In>getValidRule(inClass, eachBeanName);
			if (validRule == null) {
				return false;
			}
			boolean curFlag = validRule.valid(in);
			if (!curFlag ^ capFlag) {
				return false;
			}
		}
		return true;
	}

	public static <In> boolean valid(Class<In> inClass, In in, IValidRule<In>... beans) {
		for (IValidRule<In> eachValidRule : beans) {
			boolean curFlag = eachValidRule.valid(in);
			if (!curFlag) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * 判断输入的字符串是否是汉字，数字或字母
	 * 
	 * @param tmpStr
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isWordChar(String tmpStr) {
		if (tmpStr.matches(".*[的是和等有或及与如(其它)(其他)享(熟悉)(岗位)(任职要求)(相关)(发展)(应用)你我他它她].*")) {
			return false;
		}
		return tmpStr.matches("[\\da-zA-Z\\u4e00-\\u9fcc]+");
	}
}
