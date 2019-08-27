package part7_2_networrk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
/*
 * 현재 화면 처리 안되어 있으므로 로그인 성공되어도 화면 출력안됨.
 * 그러나 다이얼로그 화면은 확인 가능함.
 */
public class TalkClientVer2 extends JFrame {
	
	Login 				login 		= null;
	JTabbedPane 		tp 			= new JTabbedPane();
	WaitRoom			wr 			= new WaitRoom(this);
	MessageRoom			mr			= new MessageRoom(this);
	
	Socket				mySocket	= null;
	ObjectOutputStream	oos			= null;
	ObjectInputStream	ois			= null;
	String 				ip			= "127.0.0.1";
	//caffein ip
	//String 				ip			= "192.168.0.22";
	int 				port 		= 3001;
	String 				nickName 	= null;
	
	//생성자를 통해서 앞 화면에서 처리된 결과 nickName을 사용하려면 원본 주소번지가 필요
	public TalkClientVer2 (Login login) {
		this.login = login;
		//오라클 서버에서 가져온 정보(로그인)
		nickName = login.nickName;
		//화면 처리
		initDisplay();
		//통신을 위한 작업-통신은 항상 지연이 발생할 수 있으므로 화면 다음
		connect_process();
	}
	
	public void initDisplay() {
		this.getContentPane().setLayout(null);
		tp.addTab("대기실", wr);
		tp.addTab("단톡방", mr);
		tp.setBounds(5, 4, 627, 530);
		this.getContentPane().add(tp,null);
		this.setSize(655, 585);
		this.setVisible(true);
	}
	
	public void connect_process() {
		//소캣 생성
		//말하기 듣기에 필요한 객체 생성
		
		this.setTitle(nickName+"님의 대화창");
		//통신지연 가능성 > 항상 예외처리
		try {
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			oos.writeObject(Protocol.WAIT
					     +  Protocol.seperator+nickName
					     +  Protocol.seperator+"대기"
					     );
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
