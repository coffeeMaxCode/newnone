package project_myNote;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Page00_Main extends JFrame { 
	//this.setTitle(title);에서 변수가 선언되지 않음
	//선언 이 먼저 사용 이 다음
	String Tilte;
	JPanel jp_center = new JPanel();
	JButton jbtn = new JButton("Menu_bar Open");

	public Page00_Main(String title){
		this.Tilte =title;
		initDisplay();
	}

	public void initDisplay() {
		jp_center.setBackground(new Color(1,215,21));
		//디폴트 생성자는 없으면 JVM이 대신 추가해줌
		//생성자가 하나라도 존재하면 대신 하지 않음
		Button_Menu bEvent = new Button_Menu(this);
		//EventSource(Button) > Action(JVM) 
		//		> CallBack > ationPerformed(ActonEvent e)
		// e.getSource(); -- 이벤트소스의 주소번지
		jbtn.addActionListener(bEvent);
		this.add("West",jbtn);
		this.setTitle(Tilte);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Page00_Main p = new Page00_Main("Note");

	}
}
