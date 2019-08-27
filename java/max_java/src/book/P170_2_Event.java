package book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 버튼 클릭시 버튼표기가 바뀌도록 해보기
public class P170_2_Event implements ActionListener{

	P170_1 p170_1 = null;

	public P170_2_Event(P170_1 p170_1) {
		this.p170_1 =p170_1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand(); // 예시
		if("예시".equals(label)) {
			System.out.println("성공");
			p170_1.jbtn.setText("확인중");
		}else {
			p170_1.jbtn.setText("예시");
		}
	}

}
