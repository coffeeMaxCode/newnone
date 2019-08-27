package part6_Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimeServer_2 extends JFrame implements Runnable{

	ServerSocket sSocket = null;
	Socket socket = null;

	List<ServerThread> threadList = null;
	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	ServerThread sThread = null;
	
	public void initDisplay() {
		
		this.add("Center",jsp_log);
		this.setTitle("서버 log 출력");
		this.setSize(500,400);
		this.setVisible(true);
	}	
	

	public static void main(String[] args) {
		TimeServer_2 s2 = new TimeServer_2();
		s2.initDisplay();
		Thread th = new Thread(s2);
		//run호출
		th.start();
	}

	@Override
	public void run() {
		//접속한 클라이언트의 정보를 담을 Vector추가(멀티스레드안전)
		threadList = new Vector<ServerThread>();
		
		try {
			sSocket = new ServerSocket(3000);
			//무한루프에 빠져 있다.
			while(true) {
				// \n은 개행처리를 나타내는 특수문자임.
				jta_log.append("접속 대기 중"+"\n");
				socket = sSocket.accept();
				System.out.println("클라이언트 접속");
				System.out.println(socket.getInetAddress());
				System.out.println("클라이언트 정보 :"+socket.getInetAddress());
				jta_log.append(socket+"에 연결되었습니다."+"\n");
				sThread = new ServerThread(this);
				sThread.start();
			}
		}catch (IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
