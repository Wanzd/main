package com.pd.it.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Reflects {
	public static List<Method> methods(Object in) {
		if (in == null) {
			return null;
		}
		List<Method> rsList= ListX.array(in.getClass().getDeclaredMethods());
		return rsList;
	}

	public static Object field(Object in,String attrName) {
		try {
			Field field = in.getClass().getDeclaredField(attrName);
			field.setAccessible(true);
			return field.get(in);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
