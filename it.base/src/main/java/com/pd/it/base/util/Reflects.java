package com.pd.it.base.util;

import java.lang.reflect.Field;

public class Reflects {
	public static <OUT> OUT get(Object bean, String attrName) {
		Field field;
		try {
			field = bean.getClass().getDeclaredField(attrName);
			return (OUT) field.get(bean);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
