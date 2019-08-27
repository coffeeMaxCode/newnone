package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class HelloMain {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Resource resource = new FileSystemResource("M:\\WorkSpace\\spring4\\spring4\\src\\com\\di\\helloBean.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		HelloBean helloBean = (HelloBean)factory.getBean("helloBean");
		System.out.println(helloBean.getGreeting("안녕!!"));
		System.out.println("=============================");
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
								("com\\di\\helloBean.xml");
		HelloBean helloBean2 = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean2.getGreeting("Hi~~~~"));
		

	}

}
