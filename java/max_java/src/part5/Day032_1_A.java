package part5;

import java.util.ArrayList;

public class Day032_1_A {
	
	ArrayList<String> chatList = new ArrayList<>();
	//ArrayList<String> chatList = new ArrayList<>();
	
	public Day032_1_A() {
		//디폴트 생성자[파라미터가 없는 생성자]는 생략 가능
		// 파라미터가 있는 생성자는 생략 불가
		Day032_1_B b = new Day032_1_B(this);
		//chatList = new ArrayList<>();
	}
}
