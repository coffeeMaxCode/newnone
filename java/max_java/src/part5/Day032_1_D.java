package part5;

import java.util.ArrayList;

public class Day032_1_D {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();//내안에 Object
		ArrayList<String> al2 = new ArrayList<String>();
		al1.add("바나나");
		al2.add("딸기");
		for(int i=0;i<al1.size();i++) {
//오류		String str=al1.get(0);
			
			// 형변환으로 타입 일치시키기
			String str=(String) al1.get(0); 
		}
		for(int i1=0;i1<al2.size();i1++) {
			String str=al2.get(0);
		}
	}
}
