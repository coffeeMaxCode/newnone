package part7_1_networrk1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkServer extends JFrame implements Runnable {
	//동시에 여러 접속자에 대한 소켓정보 안정적으로 수집하기 위해서
	ServerSocket server = null;	
	
	//서버소켓에 접속해온 소켓 정보를 일반소켓이 받음
	Socket client = null;
	
	//사용자가 접속하면, 접속해온 사용자를 스레드로 관리
	TalkServerThread tst = null;
	
	//여러명의 접속자 관리할 리스트 필요
	List<TalkServerThread> chatList = null;
	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	//나의 로컬 IP 주소 확인용
	InetAddress local;
	
	public TalkServer() {}
	
	public void initDisplay() {
		//윈도우창 닫을 때 사용자원 반납.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					if(server !=null) {
						server.close();
					}
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.add("Center", jsp_log);
		this.setTitle("서버측 로그 출력창");
		this.setSize(300, 300);
		this.setVisible(true);
	}

	@Override
	public void run() {
		//Vector안에 있는 스레드는 누구에 대한 정보를 갖고 있나요?
		//서버에 입장한 사용자에 대한 정보를 가짐
		//이 스레드는 언제 생성하면 될까요?
		//==> 서버에 입장이 결정되면 즉시....
		//이 스레드는 언제 chatList담으면 될까요?
		//==> 서버에 사용자에 대한 대화명이 접수되면 그때 추가하면 됨.
		//스레드의 인스턴스 변수를 활용하여 서버측에 어떤 변수를 접근해야 할까요?
		//==> 일반 소켓과 TalkServer의 주소번지
		//서버에서 듣기는 어디서 이루어지면 될까요?
		//==> run()안에서
		//서버에서 말하기는 언제 처리하면 될까요?
		//==> run()안에서 듣기가 완료되면 즉시 내보내야 함.
		chatList = new Vector<TalkServerThread>();
		boolean isStop = false;
		try {
			//서버에서 포트를 결정하고 서버를 열어줌.
			server = new ServerSocket(3001);
			
			
			/////////////////////////////////////////////////
			//서버의 IP 주소 받아오기
			try {
				local = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			// 서버 포트번호 : 포트번호 결정 후에 불러와야 함으로 run 에서 위치
			jta_log.append("Open server!!\n"
							+ "   Sever IP     : "+local.getHostAddress()+"\n"
							+ "   Sever Port : "+server.getLocalPort()+"\n");
			/////////////////////////////////////////////////
			
			while(!isStop) {
				//사용자 측에서 서버에 ip와 port번호를 가지고 인스턴스화를 하면
				//서버소켓은 사용자에 대한 정보를 가지게 됨.
				//그 정보를 일반소켓에게 넘겨서 oos와 ois를 생성하고 사용하게 됨.
				client = server.accept();
				//클라이언트측 정보 출력하기
				jta_log.append(client.toString()+"\n");
				tst = new TalkServerThread(this);
				//사용자의 정보를 관리할 스레드를 기동하기
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
 
	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		new Thread(ts).start();//내안에 있는 run메소드 호출함.
	}

}
