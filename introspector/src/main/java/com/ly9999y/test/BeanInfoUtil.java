package com.ly9999y.test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {

	// 设置bean的某个属性值
	public static void setProperty(UserInfo userInfo, String userName) throws Exception {
		// 获取bean的某个属性的描述符
		PropertyDescriptor propDesc = new PropertyDescriptor(userName, UserInfo.class);
		// 获得用于写入属性值的方法
		Method methodSetUserName = propDesc.getWriteMethod();
		// 写入属性值
		methodSetUserName.invoke(userInfo, "wong");
		System.out.println("set userName:" + userInfo.getUserName());
	}

	// 获取bean的某个属性值
	public static void getProperty(UserInfo userInfo, String userName) throws Exception {
		// 获取Bean的某个属性的描述符
		PropertyDescriptor proDescriptor = new PropertyDescriptor(userName, UserInfo.class);
		// 获得用于读取属性值的方法
		Method methodGetUserName = proDescriptor.getReadMethod();
		// 读取属性值
		Object objUserName = methodGetUserName.invoke(userInfo);
		System.out.println("get userName:" + objUserName.toString());
	}
}
