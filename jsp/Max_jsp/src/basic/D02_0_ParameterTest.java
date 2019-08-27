package basic;

import java.util.HashMap;
import java.util.Map;

class Param {
	int ival;
}

public class D02_0_ParameterTest {
	/*리턴 타입 : void
	public void doGet(); override
	해결방안
	1) 전역변수 사용
		: 반드시 인스턴스화 필요
		서블릿은 인스턴스화 하지 않음
		Tomcat : 객체주입법 > 인스턴스화
	2)서블릿은 개발자가 직접 인스턴스화 하지 않음 > 불가능
	3) 파라미터를 이용							*/
	
	public void methodA(Map<String, Object> target) {
		//NullPointerException 발생
		target.put("account", 5000);
	}
	
	public void methodB(int i) {
		System.out.println(i);
	}
	
	public void methodC(Param p) {
		//호출 전 인스턴스화 > NullPointerException 없음
		int j = p.ival;
		System.out.println("j="+j);
	}
	
	public static void main(String[] args) {
		D02_0_ParameterTest pt = new D02_0_ParameterTest();
		pt.methodB(10);
		
		Param p = new Param();
		p.ival = 500;
		pt.methodC(p);
		
		Map<String, Object> target = null;
		
//		target = null : NullPointerException 발생
//		pt.methodA(target);
		target = new HashMap<String, Object>();
		pt.methodA(target);
		System.out.println(target.get("account"));
	}

}
