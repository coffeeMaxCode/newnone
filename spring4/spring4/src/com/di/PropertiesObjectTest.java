package com.di;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesObjectTest {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\mapBean.xml");
		PropertiesObject pobj =(PropertiesObject)context.getBean("propsObject");
		Properties props = pobj.someProps;
		
		Enumeration en = props.keys();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			System.out.println(props.getProperty(key));
		}
	}

}
