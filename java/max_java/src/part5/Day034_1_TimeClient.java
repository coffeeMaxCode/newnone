package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Day034_1_TimeClient extends JFrame implements Runnable {
	//선언부
	JLabel jlb_time = new JLabel("NOW");
	Socket client = null;
	
	//생성자
	public Day034_1_TimeClient() {
		
	}
	
	public void initDisplay() {
		this.add("North",jlb_time);
		this.setTitle("My timer");
		this.setSize(550, 400);
		this.setVisible(true);
	}
	
		//소켓초기화
	public void init(String ip, int port) {
		try {	//서버 ip와 port
			client = new Socket(ip, port);
		} catch (UnknownHostException ue) {
			
		} catch (IOException io) {
			
		} 
	}
	
	//메인메소드	
	public static void main(String[] args) {
		Day034_1_TimeClient tc = new Day034_1_TimeClient();
		Thread thread = new Thread(tc);
		
		thread.start();
		
		tc.initDisplay();
		
		tc.init("192.168.0.21", 3000);
	}

	@Override
	public void run() {
		PrintWriter out = null;
		BufferedReader in = null;
		String timeInfo = null;
		try {
			out = new PrintWriter(client.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((timeInfo=in.readLine())!=null){
				jlb_time.setText(timeInfo);
				Thread.sleep(1000);
			}
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				out.close();
				client.close();
			} catch (Exception e2) {
				System.out.println("???");
			}
		}
		
	}
}
