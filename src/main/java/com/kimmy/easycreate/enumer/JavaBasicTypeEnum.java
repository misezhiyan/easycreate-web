package com.kimmy.easycreate.enumer;

public enum JavaBasicTypeEnum {

	string("string", "String", "java.lang.String"), // 字符串
	integer("int", "Integer", "java.lang.Integer"),// int
	;

	String basicJavaType;
	String simpleJavaType;
	String fullJavaType;

	JavaBasicTypeEnum(String basicJavaType, String simpleJavaType, String fullJavaType) {
		this.basicJavaType = basicJavaType;
		this.simpleJavaType = simpleJavaType;
		this.fullJavaType = fullJavaType;
	}

	public static boolean isBasicJavaType(Class type) {

		boolean isBasicJavaType = false;

		if (type.getClass().equals("char")) {
			isBasicJavaType = true;
		} else if (type.getClass().equals("String")) {
			isBasicJavaType = true;
		}

		return isBasicJavaType;
	}

}
