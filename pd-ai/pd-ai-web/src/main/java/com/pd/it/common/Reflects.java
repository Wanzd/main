package com.pd.it.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class Reflects {
	public static List<Method> methods(Object in) {
		if (in == null) {
			return null;
		}
		List<Method> rsList = ListX.array(in.getClass().getMethods());
		return rsList;
	}

	public static List<Method> methods(Object in, String methodName) {
		if (in == null) {
			return null;
		}
		List<Method> rsList = ListX.array(in.getClass().getMethods());
		rsList = rsList.stream().filter(b -> b.getName().equals(methodName)).collect(Collectors.toList());
		return rsList;
	}

	public static Object field(Object in, String attrName) {
		try {
			Field field = in.getClass().getDeclaredField(attrName);
			field.setAccessible(true);
			return field.get(in);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <IN, OUT> OUT field(IN in, String attrName, Class<OUT> outClass) {
		try {
			Field field = in.getClass().getDeclaredField(attrName);
			field.setAccessible(true);
			return (OUT) field.get(in);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <IN, OUT> OUT firstExistField(IN in, String attrNames, Class<OUT> outClass) {
		String[] attrArray = attrNames.split(",");
		for (String eachAttr : attrArray) {
			OUT field = field(in, eachAttr, outClass);
			if (field != null) {
				return field;
			}
		}
		return null;
	}
}
