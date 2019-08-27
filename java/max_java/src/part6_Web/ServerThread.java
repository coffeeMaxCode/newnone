package part6_Web;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

public class ServerThread extends Thread  {
	
	Socket socket = null;
	
	TimeServer_2 s2 = new TimeServer_2();
	
	public ServerThread(TimeServer_2 s2) {
		this.s2 =s2;
	}

	//서버측에서는 현재 시간정보를 계산해서 그 정보를 클라이언트측에 제공함.
	//현재 시간 정보 만들기
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
	
	//Thread는 경합으로 인해 항시 인터셉트가 발생할 수 있으므로
	//반드시 예외처리해야함.
	@Override
	public void run() {
		
		boolean isok =  false;
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(s2.socket.getOutputStream(),true);
			while(!isok) {
				out.println(nowTime());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("인터셉트 당함");
				}
			}
		} catch (Exception e) {
			System.out.println("ServerThread의 오류");
		}
	}
}
