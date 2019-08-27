package part6_Web;

import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * TimeClientVer2는 스레드가 필요하지 않아요
 * 왜냐하면 클라이언트는 서버를 개설할 필요가 없다.
 */
public class TimeClient_2 extends JFrame{
	//내가 필요한 소켓정보 하나만....
	Socket client = null;
	//JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	//AddressBook에 생성한 jlb_time에 시간정보를 출력해하니까
	//인스턴스화 하지 않고 AddressBook에서 원본 주소번지를 받아옴.
	JLabel jlb_time = new JLabel("Now",JLabel.CENTER);
	
	public void initDisplay() {
		
		this.add("Center",jlb_time);
		this.setTitle("단말기");
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		TimeClient_2 c2 = new TimeClient_2();
		c2.initDisplay();
		try {
			//run메소드는 직접 호출할 수 없다.
			//start메소드를 호출하면 JVM이 순서대로 run메소드 호출함.
			c2.client = new Socket("192.168.0.28",3000);
			ClientThread ct = new ClientThread(c2);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
