package book;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * ActionListener 이벤트 처리 담당 인터페이스
 * 인터페이지는 추상메소드만 가지고 있음 - 기능을 결정할 수 없음
 * 구현하는 클래스가 각각 다르기 때문에
 * 어플리케이션이 배포되는 디바이스가 다르기 떄문에
 * ActionListener를 implements한 클래스가 구현체 클래스
 */
public class P170_1 extends JFrame { 
	//this.setTitle(title);에서 변수가 선언되지 않음
	//선언 이 먼저 사용 이 다음
	String Tilte;
	JButton jbtn = new JButton("예시");

	public  P170_1() {
		initDisplay();
	}	//디폴트 생성자

	public void setTitle(String title){
		this.Tilte =title;

	}

	public void initDisplay() {
		//디폴트 생성자는 없으면 JVM이 대신 추가해줌
		//생성자가 하나라도 존재하면 대신 하지 않음
		P170_2_Event pEvent = new P170_2_Event(this);
		//EventSource(Button) > Action(JVM) 
		//		> CallBack > ationPerformed(ActonEvent e)
		// e.getSource(); -- 이벤트소스의 주소번지
		jbtn.addActionListener(pEvent);
		this.add("North",jbtn);
		this.setTitle(Tilte);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {

		P170_1 p = new P170_1();
		p.setTitle("제목");

	}

	/*		@Override
		public void actionPerformed(ActionEvent e) {
			String label = e.getActionCommand(); // 예시
			if("예시".equals(label)) {
				System.out.println("성공");
			}

		}		*/
}
