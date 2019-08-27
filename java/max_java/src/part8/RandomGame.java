package part8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class RandomGame {

	public static void main(String[] args) {
		/*기반 스트림(단독 읽기 or 단독 쓰기 가능) : InputStreamReader
		    보조 스트림 (반드시 기반 스트림과 연계 )	 : BufferedReader 	*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br2 = new BufferedReader(is);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		*/
		
		System.out.println("0~9사이의 숫자를 입력하시오");
		try {
			String user = br.readLine();
			System.out.println("사용자 입력값 : "+user);
			int user2 = Integer.parseInt(user);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}
