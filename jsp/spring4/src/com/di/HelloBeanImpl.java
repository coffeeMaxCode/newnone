package com.di;

import org.apache.log4j.Logger;

/* Spring에서는 절대 직접 인스턴스화 하지 않음
 * 만일, 인스턴스화 하면, 스피링의 Bean관리를 받지 못함
 * 대신 setter 객체 주입법과 생성자 객체 주입법으로 객체주입을 받아 사용
 * setter 객체 주입법은 자바코드로 처리 // 생성자 객체 주입법은 xml코드로 처리
 * 스프링 안에 Beans를 관리해주는 클래스가 있음

 * ApplicationContext + BeanFactory = 두개의 클래스가 빈관리 전담
 * ApplicationContext : org.springframework.context  에서 제공
 * spring-context-4.3.25.jar
 * BeanFactory 		  : org.springframework.beans  에서 제공
 * spring-context-4.3.25.jar

 * IoC(Inversion of Conversion) Container = 스프링 : 역제어
 // 기존방식
 * 자바 기반의 어플리케이션 개발 시, 자바 객체를 생성 및 서로 간의 의존관계 
 * 연결하는 작업에 대한 제어권은 개발되는 어플리케이션에 존재
 *  →→ 컴포넌트 간 결합도가 높아져 컴포넌트 재사용/확장이 어려운 문제 발생
 * 
 // IoC 사용시
 * 제어권이 container에게 넘어가 객체의 생명주기를컨테이너가 전담

 * Ex) Servlet, EJB
 * 장점 : 컴포넌트간 결합도가 낮아져 컴포넌트 재사용/확장이 쉬움
 * 		 컴포넌트 의존관계 변경이 쉬움

 * IoC : 제어군의 역전
 * 객체의 생성 및 생명주기에 대한 제어권이 개발자에서 Container로 넘어갔다는 것 의미

 * 스프링 컨테이너의 유형
 * Spring Container = BeanFactory + ApplicationContext

 * 	BeanFactory 
 * : 객체를 관리하는 고급 설정 기법
 * : Bean들에 대한 생성/소멸/라이플사이클 과 같이 컨테이너가 빈을 관리에 필요한 기능 제공

 * 	XmlBeanFactory
 * : 어플리케이션을 구성하는 객체 속성 및 참조관계를 XML기반의 속성 정의파일에 정의
 * 											 → 컨테이너가 관리 가능하게 만듬
 * Resource resource = new FileSystemResource("bean.xml");
 * BeanFactory factory = new XmlBeanFactory(resource);

 * 	ApplicationContext 
 * : BeanFactory 의 모든 기능 제공
 * : Spring AOP 기능, 메시지 자원 핸들링, 이벤트 위임 추가 제공
 */


/* 구현체 */
public class HelloBeanImpl implements HelloBean{
	static Logger logger = Logger.getLogger(HelloBeanImpl.class);
	
	// msg : 전역변수 : helloBean.xml에 담겨있음
	String msg = null;
	/* setter : 전달받은 값을 내부에서 가공해 필드에 넣어주는 방식 ★역제어
	 * getter : 내부에서 가공된 값을 꺼냄 : !필요없음!   ☆순제어					 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getGreeting(String msg) {
		// this.msg > xml 값
		return "Spring - this.msg : "+ this.msg;
		
		// msg > java에서 넣어준 값
		//return "Spring : "+ msg;
	}
	
	@Override
	public String getGreeting1(String msg) {
		// this.msg > xml 값
		//return "Spring : "+ this.msg;
		
		// msg > java에서 넣어준 값
		return "Spring - msg : "+ msg;
	}
	
	//Bean 초기화 마친 후, 호출되는 메소드
	public void exampleInit() {
		logger.info("initMethod 호출");
	}
	
	//Bean 소멸되기 전, 호출되는 메소드
	public void exampleDestroy() {
		logger.info("destroyMethod 호출");
	}

}
