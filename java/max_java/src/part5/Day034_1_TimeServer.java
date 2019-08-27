package part5;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/* API에 필요한 클래스를 찾은 후, 생성자 확인
 * 파리미터를 보고 선택할 것
 * 
 */
public class Day034_1_TimeServer extends JFrame implements Runnable {

	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	Socket socket = null;
	ServerSocket sSocket = null;
	
	public void initDisplay() {
		
		this.add("North",jta_log);
		this.add("Center",jsp_log);
		this.setTitle("서버 log 출력");
		this.setSize(500,400);
		this.setVisible(true);
		
		this.addWindowListener(new WindowListener() {			
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);			
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
	}
	
	public Day034_1_TimeServer() {}
	
			//현재 시간 만들기
	public String nowTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour:""+hour)
				+":"+
				(min < 10 ? "0"+min:""+min)
				+":"+
				(sec < 10 ? "0"+sec:""+sec);
	}
	
	public static void main(String[] args) {
		/*메소드 안에서 for문 or try-catch블럭은 {} : 하나의 섹션임
		//{}내부에서 선언 시, 지역변수 // 밖에서 변수 선언해야 다시 사용 가능*/
		
		//화면처리를 생성자에서 하고 있으므로 서버소켓 생성에 앞서 먼저 생성자를 호출해야 한다
		Day034_1_TimeServer ts = new Day034_1_TimeServer();
		ts.initDisplay();
		
		try {
			/*포트번호 1~65574                     까지 존재
			운영체제 포트번호로    1~1023	사용*/
			ts.sSocket = new ServerSocket(3000);
			while(true){
			System.out.println("로딩 중");
			ts.socket = ts.sSocket.accept();
			System.out.println(ts.socket.getInetAddress());
			ts.jta_log.append(ts.socket.getInetAddress().toString()+"\n");
			ts.jta_log.append(ts.nowTime());

			Thread thread = new Thread(ts);
			thread.start();
			}
		} catch (IOException e1) {
			System.out.println("서버를 확인해 주세요");
			System.out.println("다른 포트번호를 사용하세요");
		}finally {
			try {
				if(ts.socket !=null) ts.socket.close();
				if(ts.sSocket !=null) ts.sSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		System.out.println("서버 기동 성공");
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				out.println(nowTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("");
				}
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

	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
}