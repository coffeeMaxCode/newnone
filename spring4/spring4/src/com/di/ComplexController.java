package com.di;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexController  {
	Logger logger = Logger.getLogger(ComplexController.class);

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\mapBean.xml");
		ComplexObject someMap =(ComplexObject)context.getBean("moreComplexObject");
		
		System.out.println("내가한 방식");
		System.out.println(someMap.COMap().get("First"));
		System.out.println(someMap.COMap().get("Second"));
		System.out.println(someMap.COMap().get("Third"));
		
		System.out.println("강사님 방식");		
		//Map<String, Object> rMap = new Map()<>;
		System.out.println("=======================");


		System.out.println("이상한 방법 1");
		for ( String key : someMap.COMap().keySet() ) {
		    System.out.println("key : " + key +" / value : " + someMap.COMap().get(key));
		}
		 
		System.out.println("이상한 방법 2");
		for ( Map.Entry<String, Object> entry : someMap.COMap().entrySet() ) {
		    System.out.println("key : " + entry.getKey() +" / value : " + entry.getValue());
		}
		
		System.out.println("이상한 방법 3");
		Iterator<String> keys = someMap.COMap().keySet().iterator();
		while ( keys.hasNext() ) {
		    String key = keys.next();
		    System.out.println("key : " + key +" / value : " + someMap.COMap().get(key));
		}   

	}

}
