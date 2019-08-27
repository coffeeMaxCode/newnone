package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
		Resource resource = new FileSystemResource("M:\\WorkSpace\\jsp\\spring4\\src\\com\\di\\helloBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource); // 밑줄은 향후 업데이트되지 않는다
		
		//factory 에서 클래스????????????????를 관리
		HelloBean helloBean = (HelloBean)factory.getBean("helloBean");
		System.out.println("BeanFactory");
		System.out.println(helloBean.getGreeting("hi"));
		System.out.println(helloBean.getGreeting1("hi"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\di\\helloBean.xml");
		System.out.println("ApplicationContext");
		HelloBean helloBean2 = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean2.getGreeting("hello"));
		System.out.println(helloBean2.getGreeting1("hello"));
	}

}
