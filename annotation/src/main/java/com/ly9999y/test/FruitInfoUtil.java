package com.ly9999y.test;

import java.lang.reflect.Field;

public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = " 水果名称：";
		String strFruitColor = " 水果颜色：";
		String strFruitProvicer = "供应商信息：";

		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field :
				declaredFields) {

			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName annotation = field.getAnnotation(FruitName.class);
				strFruitName = strFruitName + annotation.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor annotation = (FruitColor) field.getAnnotation(FruitColor.class);
				strFruitColor = strFruitColor + annotation.fruitColor().toString();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider annotation = (FruitProvider) field.getAnnotation(FruitProvider.class);
				strFruitProvicer = " 供应商编号：" + annotation.id() + " 供应商名称：" + annotation.name() + " 供应商地址：" + annotation.address();
				System.out.println(strFruitProvicer);
			}
		}
	}

}
