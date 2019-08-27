package project_BaseballGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Part0_0_BaseballGame implements ActionListener {
	//선언부
	
	// 게임 결과창 추가	
	JPanel jp_center = new JPanel();
	
	// 게임 결과창 결과 출력물
	JTextArea text;
	
	public JTextArea getContent() {
		return text;
	}
	
	JTextArea jta_display = new JTextArea();
	
	//스크롤바 - 
	JScrollPane jsp_display = 
			new JScrollPane(jta_display
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//jp_east속지에 버튼 4개 추가 - new GridLayout(4,1);
	JPanel jp_east = new JPanel();
	JTextField jtf_user = new JTextField();
	// 버튼 생성
	JButton jbtn_new = new JButton("New Game");
	JButton jbtn_dap = new JButton("DO u wanna know \n What Anwser is?");
	JButton jbtn_clear = new JButton("Delete All");
	JButton jbtn_exit = new JButton("Exist");



	//컴퓨터가 채번할 숫자 3개 담을 배열로 선언
	int com[] = new int[3]; // 현재는 3개방에 0이 담겨 있음
	//사용자가 입력한 숫자 3개 담을 배열로 선언
	int peo[] = new int[3];


	//새 게임을 눌렀을 때 임의의 숫자를 채번하는 메소드 선언
	public void ranCom() {
		Random ran = new Random();
		com[0] = ran.nextInt(10);
		do {
			com[1] = ran.nextInt(10);
		}while(com[0]==com[1]);				// do while1 end
		do {
			com[2] = ran.nextInt(10);
		}while((com[0]==com[2])|(com[1]==com[2]));		// do while2 end

		System.out.println("New Game start!");
		// 화면 결과창에 새게임 시작  출력하기
		text.setText("");
		text.append("New Game!"+"\n"+"Type the 3 different number");
	}


	//화면 처리부
	public void initDisplay() {
		
		//센터 서쪽 배경색 설정
		jp_center.setBackground(new Color(224,203,234));
		jp_east.setBackground(new Color(255,255,101));
		// 창 크기 설정
		int width = 400;		//지역변수 = 메소드 안에 선언
		int height = 500;		//지역변수 > 화면크기는 고정이므로
		// 타이틀 설정
		String title = "야구숫자게임 ver1.0";
		//속지 레이아웃을 BorderLayout으로 변경
		jp_center.setLayout(new BorderLayout());
		//jp_east 속지 레이아웃을 GridLayout으로 변경
		jp_east.setLayout(new  GridLayout(4,1));
		//JFrame 중앙에 hp_center, 동쪽에 jp_east
		jp_center.add("Center",jsp_display);
		this.add("Center",jp_center);
		//버튼 추가
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jta_display.setBackground(new Color(255,255,200));
		//채팅창 추가
		jp_center.add("South",jtf_user);
		this.add("East",jp_east);
		this.setTitle(title);
		this.setSize(width, height);
		this.setVisible(true);

		//버튼의 배경색과 글자색 변경
		jbtn_new.setBackground(new Color(106,87,115));
		jbtn_new.setForeground(new Color(255,255,255));
		jbtn_dap.setBackground(new Color(106,32,20));
		jbtn_dap.setForeground(new Color(255,255,255));
		jbtn_clear.setBackground(new Color(247,169,0));
		jbtn_clear.setForeground(new Color(255,255,255));
		jbtn_exit.setBackground(new Color(103,90,208));
		jbtn_exit.setForeground(new Color(255,255,255));
		
		// 게임 출력창
//		jp_center.setLayout(new BoxLayout(jp_center, BoxLayout.Y_AXIS));
		text = new JTextArea("Let's play new Game! \n Click the New Game button", 30, 30);
		text.setEnabled(false);
		jp_center.add(text);

	}
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	private void setSize(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	private void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}


	private void add(String string, JPanel jp_center2) {
		// TODO Auto-generated method stub
		
	}


	//판정
	/*********************************************************
	 * 
	 * @param user 	- 사용자가 입력한 숫자를 담을 변수
	 * @return		- 사용자가 입력한 숫자와 추출한 숫자를 비교해 힌트문 반환
	 **********************************************************/
	public String account(String user) {
		//파라미터로 새로운 숫자를 받아올 때마다 볼카운트 새롭게 시작
		//또 사용자가 입력한 값은 사용자가 JTextField에 숫자를 입력후 엔터 입력 시
		//account("###")을 호출 해야함 > 파라미터
		int strike = 0;
		int ball = 0;
		int temp = 0; // 문자열을 숫자 타입으로 형전환하여 담는 변수 선언
		try {
			temp = Integer.parseInt(user);
		} catch (NumberFormatException e) {
			return "Only Number";
		}
		peo[0] = temp/100;
		peo[1] = (temp%100)/10;
		peo[2] = temp%10;
		//사용자가 입력한 숫자가 문자열로 넘어옴 > peo배열에 다시 담아야함
		//insert here = peo배열 초기화 진행
		//백의자리   user/100
		//십의자리 (user%100)/10
		//일의자리   user%10
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				//Ball 판정
				if(com[i]==peo[j]) {
					//Strike 판정
					if(i==j) {
						strike++;
					} 		// if strike end
					ball++;
				}			// if ball end
			}				// for2 end
		}					// for1 end
		return "1S 1B";
	}
	//

	//메인메소드	-	entry point	-	call back method
	public static void main(String[] args) {
		Part0_0_BaseballGame bg = new Part0_0_BaseballGame();
		bg.initDisplay();

	}
	//콜백 메소드 = 시스템이 자동으로 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 이벤트 소스(jtf_user)에 대한 주소번지를 읽을 수 있음
		System.out.println("obj:"+obj);
		// 입력 받기; 감지된 주소번지 == 입력한 주소번지
		if(obj==jtf_user) {
			String userInput = jtf_user.getText();
			jta_display.append(userInput+"\n");
			jtf_user.setText("");
		}
		//새게임 기능
		else if(obj==jbtn_new) {
			ranCom();
			jta_display.append(com[0]+","+com[1]+","+com[2]+"\n");
		}
		//clear 기능
		else if(obj==jbtn_clear) {
			jta_display.setText("");
		}

	}
}
