package part4;

public class Day023_1_4_DropShip extends Day023_1_0_Unit implements Day023_1_3_Movable {
	
	@Override
	void display() {
		System.out.println("I'm DropShip");
	}
	
	void load() {}
	void unload() {}
	
	@Override
	public void back() {		
	}
	/*
	 * 메소드 선언시 {좌중괄호 , 우중괄호} 있다는 것만으로도 구현으로 본다.
	 * 선언이 아니다.
	 * 선언은 ; 끝났을 때가 선언이다.
	 * 아래 메소드는 Movable인터페이스에서 선언된 추상메소드를 구현한 메소드이다.
	 * 따라서 인터페이스안에는 구현된 부분이 없다.
	 * 구현체 클래스는 Movable 인터페이스를 implements한 클래스가 구현체 클래스인 것이다.
	 */
	@Override
	public void move(int x, int y) {
		System.out.println("DropShip이 "+x+","+y+"좌표로 이동하였다.");
		
	}
}