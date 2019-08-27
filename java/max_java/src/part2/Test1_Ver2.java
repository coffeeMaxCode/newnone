package part2;

import java.util.Random;

/*
 * -10에서 10사이의 정수 10개를 채번하고 음수와 합과 양수의 합을 구하시오.
 * 5장 - 클래스
 * 인스턴스화를 왜 해야하는가?
 * 클래스 구성요소 2가지가 뭐지?
 * 1)변수 - field
 * 2)메소드 - method
 * 변수와 메소드는 소유하고 있는 클래스이름이 있다.
 * 자바에서 제공되는 클래스가 있다.
 * 변수나 메소드를 재사용하기 위해서는 반드시 인스턴스화 해야함.
 * 클래스타입 변수명 = null;//클래스선언
 * 변수명 = new 클래스타입();//생성자
 */
public class Test1_Ver2 {
	int is[] = new int[10];
	int hap1 = 0;//양수의 합을 담을 변수
	int hap2 = 0;//음수의 합을 담을 변수
	//임의의 숫자를 채번하는 메소드 선언하기
	//배열을 사용해서 초기화 할 수 있으므로 for문 사용하였다.
	void randomValue() {
		Random r = new Random();
		for(int i=0;i<10;i++) {
			is[i] = r.nextInt(21)-10;
		}
	}////end of randomValue
	//양수의 합을 구하는 메소드 선언
	int plusHap() {
		for(int i=0;i<10;i++) {
			if(is[i]>=0) {//너 양수니?
				hap1+=is[i];
			}
		}
		return hap1;
	}/////end of plusHap
	//음수의 합을 구하는 메소드 선언
	int minusHap() {
		for(int i=0;i<10;i++) {
			if(is[i]<0) {//너 음수니?
				hap2+=is[i];
			}
		}
		return hap2;
	}
	void printRandomValue() {
		for(int i=0;i<10;i++) {
			System.out.println(is[i]);
		}
	}
	//전역변수로 선언하면 메소드에서 사용하고 싶을때 언제든지 사용가능
	//만일 지역변수로 선언했다면 메소드의 파라미터로 넘겨주어야 유지된다.
	void printRandomValue(int i1,int i2,int i3,int i4,int i5, int i6, int i7, int i8, int i9, int i10) {

	}
	public static void main(String[] args) {
		Test1_Ver2 t1 = new Test1_Ver2();
		t1.randomValue();
		t1.printRandomValue();
		t1.hap1 = t1.plusHap();
		t1.hap2 = t1.minusHap();
		System.out.println("양수의 합은 "+t1.hap1);
		System.out.println("음수의 합은 "+t1.hap2);
		/*
		 * for(int i=0;i<100;i++) { int user = r.nextInt(21)-10;
		 * System.out.println(user); }
		 */
	}

}






