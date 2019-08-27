package project_BaseballGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Part1_3_BaseballGameEvent extends AbstractAction implements ActionListener  {
	
	//시도 횟수
	int tryCount = 0;
	Part1_1_BaseballGameView view = null;
	Part1_2_BaseballGameLogic logic = null;
	
	public Part1_3_BaseballGameEvent(Part1_1_BaseballGameView view, Part1_2_BaseballGameLogic logic) {
		this.view = view;
		this.logic = logic;
	}


	public void GameEvent() {
	//이벤트 소스와 이벤트처리를 담당하는 클래스 연결
	//채팅 입력 이벤트
	view.jtf_user.addActionListener(this);
	//버튼 클릭 이벤트
	view.jbtn_new.addActionListener(this);
	view.jbtn_dap.addActionListener(this);
	view.jbtn_clear.addActionListener(this);
	view.jbtn_exit.addActionListener(this);

}
//	// 결과 출력창 설정, 엔터입력시 이벤트 등록
//	public void Enter() {
//	logic.peo = new JTextField;
//	KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
//	logic.peo.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
//	Action pressEnter = new Part1_0_BaseballGameEvent(this);
//	logic.peo.getActionMap().put("ENTER", pressEnter);		
//	jTextAreaPanel.add(writingAnswer);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 소스(jtf_user)에 대한 주소번지를 읽을 수 있음
		Object obj = e.getSource(); 
		System.out.println("obj:"+obj);
		
		// 입력 받기; 감지된 주소번지 == 입력한 주소번지
		if(obj==view.jtf_user) {
			String userInput = view.jtf_user.getText();
			// Enter 입력
			if(userInput.length()!=3) {
				JOptionPane.showMessageDialog(view, "put the 3 diffrent number."
												  , "Error", JOptionPane.ERROR_MESSAGE);
				view.jtf_user.setText("");
				return;//actionPerformed 탈출
			}		
			//시도 결과 출력
			view.jta_display.append(++tryCount+"."+userInput+": "+logic.account(userInput)+"\n");
			view.jtf_user.setText("");
		}
		
		//새게임 기능
		else if(obj==view.jbtn_new) {
			view.jta_display.append(logic.com[0]+","+logic.com[1]+","+logic.com[2]+"\n새 게임을 시작합니다\n");
			logic.ranCom();
		}
		//정답 확인
		else if(obj == view.jbtn_dap) {
			view.jta_display.append("Answer is"+logic.com[0]+","+logic.com[1]+","+logic.com[2]+
																		"\n Do it better next time\n");
		}
		//clear 기능
		else if(obj==view.jbtn_clear) {
			view.jta_display.setText("");
		}
		//exit 기능
		else if(obj==view.jbtn_exit) {
			System.exit(0);
		}
		
	}

}
