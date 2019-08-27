package book;

import javax.swing.JFrame;
/*
 *  * A is B 관계라면 서로 상속처리
 *  상속받을 때, 하위클래스를 상속받는 것이 더 많은 것을 누릴 수 있음
 */
public class P170_0 extends JFrame {
	//this.setTitle(title);에서 변수가 선언되지 않음
	//선언 이 먼저 사용 이 다음
	String Tilte;

	public P170_0(String title){
		this.Tilte =title;

	}

	public void initDisplay() {
		this.setTitle(Tilte);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {

		P170_0 p = new P170_0("제목");
		p.initDisplay();
	}
}
