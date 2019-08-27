package project_Simulation;

import javax.swing.JButton;

public class TV {
	JButton jbtn_onoff = new JButton("전원");
	JButton jbtn_plus = new JButton("volumn +");
	JButton jbtn_minus = new JButton("volumn -");
	boolean onoff = false;					//초기에 전원 off
	int volumn = 0;							//노이즈값
		// 전역변수 초기화 생략 가능
		// 왜냐하면 생성자가 대신 처리
	public TV( ) {		//생성자
		System.out.println("디폴트 생성자 호출 성공");
	}
	public TV(boolean onoff) {		//생성자
		System.out.println("파라미터가 있는 생성자호출 성공");
	}

	public void powerOn()	{
		onoff= true;						//전원 on
	}
	public void powerOff()	{
		onoff= false;						//전원 off
	}
}
