package part3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Day018_1_AddressBook extends JFrame implements ActionListener {

	Day018_2_SubBook subbook = null;
	static Day018_1_AddressBook abook = null;
	JPanel jp_north = new JPanel();
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_det = new JButton("상세조회");

	public void initDisplay() {
		// 버튼 액션 활성화
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_det.addActionListener(this);

		jp_north.setLayout(new FlowLayout());
		//버튼 설정
		jp_north.add("North",jbtn_ins);
		jp_north.add("North",jbtn_upd);
		jp_north.add("North",jbtn_del);
		jp_north.add("North",jbtn_det);
		//버튼 추가
		this.add("North",jp_north);
		//창 크기
		this.setSize(500, 600);
		//창 실행
		this.setVisible(true);


	}
	//저장버튼 클릭 > 새로고침 처리 메소드 구현
	public void refreshData() {
		System.out.println("새로고침 처리");

	}

	public static void main(String[] args) {
		if(abook==null) {
			abook = new Day018_1_AddressBook();
		}
		abook.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//액션
		String label = ae.getActionCommand();
		//액션 실행 시 조건
		if("입력".equals(label)) {
			subbook = null;
			subbook = new Day018_2_SubBook(abook);
			subbook.initDisplay();
			subbook.setVisible(true);
		}else if("수정".equals(label)) {
			subbook = null;
			subbook = new Day018_2_SubBook(abook);
			subbook.initDisplay();
			subbook.setVisible(true);
		}else if("상세조회".equals(label)) {
			//문제 제기 - 화면 그리는 메소드가 사라짐
			//남은 값 지우고 새롭게 인스턴스화
			subbook = null;
			subbook = new Day018_2_SubBook();
			subbook.set(label,abook,false);
		}

	}

}
