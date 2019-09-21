package com.kimmy.easycreate.util;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kimmy.easycreate.enumer.JavaBasicTypeEnum;

public class WebUtil {

	public static <T> List<T> matchList(HttpServletRequest request, Class clazz) throws InstantiationException, IllegalAccessException {

		T t = (T) clazz.newInstance();
		Field[] declaredFields = clazz.getDeclaredFields();

		for (Field declaredField : declaredFields) {

			// 基本类型
			Class type = declaredField.getType();
			if (JavaBasicTypeEnum.isBasicJavaType(type)) {
				String name = declaredField.getName();
				String value = request.getParameter(name);
			}

			// list
			// bean

		}

		return null;
	}

}
