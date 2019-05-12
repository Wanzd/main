package com.pd.it.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflects {
	public static <OUT> OUT field(Object bean, Class<OUT> clazz, String... strArrayAttrName) {
		Field field;
		for (String strEach : strArrayAttrName) {
			try {
				field = bean.getClass().getDeclaredField(strEach);
				field.setAccessible(true);
				return (OUT) field.get(bean);
			} catch (NoSuchFieldException e) {
			} catch (SecurityException e) {
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}
		return null;
	}

	public static <OUT> OUT field(Object obj, String attr) {
		Field field;
		try {
			field = obj.getClass().getDeclaredField(attr);
			field.setAccessible(true);
			return (OUT) field.get(obj);
		} catch (NoSuchFieldException e) {
		} catch (SecurityException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
		return null;
	}

	public static Method method(Object obj, String methodName) {
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method eachMethod : methods) {
			if (eachMethod.getName().equals(methodName)) {
				return eachMethod;
			}
		}
		return null;
	}

}
