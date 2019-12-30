package com.ly9999y.test;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanInfoTest {
	/**
	 * @param args the command line arguments
	 */
//	public static void main(String[] args) {
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserName("peida");
//		try {
//			BeanInfoUtil.getProperty(userInfo, "userName");
//			BeanInfoUtil.setProperty(userInfo, "userName");
//			BeanInfoUtil.getProperty(userInfo, "userName");
//			BeanInfoUtil2.setPropertyByIntrospector(userInfo, "userName");
//			BeanInfoUtil2.getPropertyByIntrospector(userInfo, "userName");
//			BeanInfoUtil.setProperty(userInfo, "age");  // IllegalArgumentException
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("peida");
		try {
			BeanUtils.setProperty(userInfo, "userName", "peida");
			System.out.println("set userName:" + userInfo.getUserName());
			System.out.println("get userName:" + BeanUtils.getProperty(userInfo, "userName"));
			BeanUtils.setProperty(userInfo, "age", 18);
			System.out.println("set age:" + userInfo.getAge());
			System.out.println("get age:" + BeanUtils.getProperty(userInfo, "age"));
			System.out.println("get userName type:" + BeanUtils.getProperty(userInfo, "userName").getClass().getName());
			System.out.println("get age type:" + BeanUtils.getProperty(userInfo, "age").getClass().getName());
			PropertyUtils.setProperty(userInfo, "age", 8);
			System.out.println(PropertyUtils.getProperty(userInfo, "age"));
			System.out.println(PropertyUtils.getProperty(userInfo, "age").getClass().getName());
			PropertyUtils.setProperty(userInfo, "age", "8");  // IllegalArgumentException
		} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
