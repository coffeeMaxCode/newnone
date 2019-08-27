package book;

import java.util.ArrayList;

public class P222_2_ArrayListTest1 {

	public ArrayList setArrayList() {		//담기

		ArrayList WCI = new ArrayList();

		P222_1_evrika	WC1	= new P222_1_evrika("Renaissance");
		P222_1_evrika	WC2	= new P222_1_evrika("Global Revolution");
		P222_1_evrika	WC3	= new P222_1_evrika("Universe Revolution");

		boolean isWC1 = WCI.add(WC1);
		if(isWC1) System.out.println("Gold Rush");
		else System.out.println("Fail : Dark Ages");

		boolean isWC2 = WCI.add(WC2);
		if(isWC2) System.out.println("Generation Next");
		else System.out.println("Fail : World War Start");

		boolean isWC3 = WCI.add(WC3);
		if(isWC3) System.out.println("Terran");
		else System.out.println("Fail : Planet Escape");

		return WCI;

	}

	public static void main(String[] args) {
		P222_2_ArrayListTest1 a1 = new P222_2_ArrayListTest1();
		//메소드 리턴타입으로 주소번지를 받아옴
		ArrayList WCIZ = a1.setArrayList();
		ArrayList a2 = a1.setArrayList();
		//개선된 for문을 사용하여 반복처리
		System.out.println("======================");
		for(Object obj:WCIZ) {
			//ArrayList 안에 담긴 타입이  P222_1_evrika 로 타입을 맞춤
			P222_1_evrika erk = (P222_1_evrika)obj;
			//System.out.println(obj);
			//주소번지를 활용하여 
			System.out.println(erk.evrika);
		}
		System.out.println("======================");
//		double d = 3.14;
//		int j = (int)d;
		for (int i =0; i<WCIZ.size();i++) {
			P222_1_evrika erk = (P222_1_evrika)WCIZ.get(i);
			String evrika = erk.evrika;
			System.out.println(evrika);
		}

	}

}
