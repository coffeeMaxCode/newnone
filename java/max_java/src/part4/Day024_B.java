package part4;

public class Day024_B {
	int b;
	Day024_A a = null;
	
	public Day024_B(Day024_A a) {
		System.out.println("B A");
		this.a = a;
	}
	
	public void meathodB() {
		//생성자의 파라미터로 넘어온 변수 a를 전역변수와 초기화(7번)
		//14번이 정상적으로 호출 성공
		a.meathodA();
		System.out.println("B");
	}
}
