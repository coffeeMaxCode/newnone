package part4;

public class Day024_A {
	int a;

	public void meathodA() {
		System.out.println("A");
	}
	// methodB를 클래스A에서 호출 가능하게 해줌
	Day024_B b = new Day024_B(this);

	public Day024_A() {
		b.meathodB();
	}

	public static void main(String args[]) {
		Day024_A a = new Day024_A();
		a.meathodA();
	}

}
