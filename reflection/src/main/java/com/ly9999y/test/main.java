package com.ly9999y.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class main {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		Reflection test1 = new Reflection();
		test1.setProp1("Hello");
		test1.setProp2(100);

		Class<Reflection> reflectionClass = Reflection.class;
		Class<?> forName = Class.forName("com.ly9999y.test.Reflection");

		System.out.println(reflectionClass == forName);

		System.out.println(reflectionClass.getName());//类全名，包含包名

		System.out.println(reflectionClass.getSimpleName());//类名

		System.out.println(reflectionClass.getModifiers());

		System.out.println(Modifier.isPublic(reflectionClass.getModifiers()));
		System.out.println(Modifier.isFinal(reflectionClass.getModifiers()));

		System.out.println(reflectionClass.getPackage());
		System.out.println(reflectionClass.getSuperclass());

		System.out.println(reflectionClass.getInterfaces().length);

		System.out.println(reflectionClass.getConstructors().length);
		Constructor<?>[] constructors = reflectionClass.getConstructors();
		for (Constructor constructor :
				constructors) {
			Object o = constructor.newInstance();
		}


		Method[] methods = reflectionClass.getMethods();//获取所有方法
		System.out.println("getMethods:" + methods.length);
		for (Method method : methods) {
			System.out.println("method.getName:" + method);
		}

		Method method = reflectionClass.getMethod("getProp1", null);//获取指定方法
		System.out.println("getMethod(,):" + method);
		Object methodVlaue = method.invoke(test1, null);//调用方法
		System.out.println("method.invoke(,):" + methodVlaue);

		Method method3 = reflectionClass.getMethod("setProp3", Double.class);//获取指定方法
		System.out.println("getMethod(,):" + method3);
		Object methodVlaue3 = method3.invoke(test1, 2.0);//调用setter方法，该方法没有返回值，所以methodVlaue3为null；此处注意参数2.0 ，不能用null
		System.out.println("method.invoke(,):" + methodVlaue3);

		Field[] fields=reflectionClass.getDeclaredFields();//获取变量
		System.out.println("getDeclaredFields:"+fields.length);
		for(Field field:fields){
			field.setAccessible(true);
			field.set(test1,null);//设置字段的值
			System.out.println("field.getAnnotations:"+field.getAnnotations().length+"\tfield.getName:"+field.getName()+"\tfield.get:"+field.get(test1));//获取实例属性名和值

		}
		Annotation[] annos=reflectionClass.getAnnotations();//获取类注解
		System.out.println("getAnnotations:"+annos.length);
	}
}
