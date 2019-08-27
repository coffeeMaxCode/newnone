package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class insaListSimulation {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
	/*BeanFactory*/
		System.out.println("BeanFactory 방식");
		
		Resource resource = new FileSystemResource("M:\\WorkSpace\\spring4\\spring4\\src\\com\\di\\listBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		InsaList ListBF = (InsaList)factory.getBean("insa");
		
		System.out.println("첫번째 List = "+ListBF.List().get(0));
		System.out.println("두번째 List = "+ListBF.List().get(1));
		System.out.println("세번째 List = "+ListBF.List().get(2));
		
	/*ApplicationContext*/
		System.out.println("ApplicationContext 방식");
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\listBean.xml");
		InsaList ListAC = (InsaList)context.getBean("insa");
		
		System.out.println("첫번째 List = "+ListAC.List().get(0));
		System.out.println("두번째 List = "+ListAC.List().get(1));
		System.out.println("세번째 List = "+ListAC.List().get(2));
	}
	
}
