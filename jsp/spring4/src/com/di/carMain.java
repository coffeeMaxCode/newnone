package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class carMain {

	public static void main(String[] args) {
		
	//객체 생성
		ChairMan chairMan = new ChairMan();
		
	//객체 소멸
		//candidate 상태로 전환
		chairMan = null;
		
		chairMan = new ChairMan();
		
		Resource resource = new FileSystemResource("M:\\WorkSpace\\jsp\\spring4\\src\\com\\di\\carBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		/* BeanFactory */
		System.out.println("BeanFactory 방식");
		
		ChairMan myCarB = (ChairMan)factory.getBean("myCar");
		System.out.println(myCarB.toString());
		
		ChairMan yourCarB = (ChairMan)factory.getBean("yourCar");
		System.out.println(yourCarB.toString());
		
		ChairMan ourCarB = (ChairMan)factory.getBean("ourCar");
		System.out.println(ourCarB.toString());
		
		/* ApplicationContext */		
		System.out.println("ApplicationContext 방식");
		
		ApplicationContext context 
					= new ClassPathXmlApplicationContext("com\\di\\carBean.xml");
		
		ChairMan myCarA = (ChairMan)context.getBean("myCar");
		System.out.println(myCarA.toString());
		
		ChairMan yourCarA = (ChairMan)context.getBean("yourCar");
		System.out.println(yourCarA.toString());
		
		ChairMan ourCarA = (ChairMan)context.getBean("ourCar");
		System.out.println(ourCarA.toString());
	}

}
