package book;

import java.util.ArrayList;

/*
 * 사원 집합에서 사원번호=7566 사원에 대해 정보 조회 > ArrayList 담기
 * 제네릭 타입은?		--ArrayList에 원시형 타입 못넣음 오브젝트 타입만 넣는가?
 * Hint! 서로 다른 타입
 */
public class P222_3_ArrayListTest2 {

	public static void main(String[] args) {
		//이름 String
		//급여 double
		//부서번호 int

		String name = new String("JONES");
		Double sal = new Double(3000.56);
		Integer deptno = new Integer(20);
		
		ArrayList<String>  al1 = new ArrayList<String> ();
		ArrayList<Double>  al2 = new ArrayList<Double> ();
		ArrayList<Integer>  al3 = new ArrayList<Integer> ();

		ArrayList<Object>  al0 = new ArrayList<Object> ();
		
//		al1.add(name);
//		al1.add(sal);
//		al1.add(deptno);
		
		al0.add(name);
		al0.add(sal);
		al0.add(deptno);
		
		al0.add(1, "break up");
		
		if(al0.isEmpty()) {
			System.out.println("Nothing");
		}else {
			System.out.println("Here~");
		}
		
		// 화면 솔루션과 연계 시, ☆ instanceof 활용 ☆
		for(Object obj:al0) {
			if(obj instanceof String) {	//타입을 물어보는 것
				System.out.println(obj.toString());
			}
			else if(obj instanceof Double) {	//타입을 물어보는 것
				System.out.println(obj.toString()); //더블 > String 형전환
				System.out.println(Double.valueOf(obj.toString())+10); // 더블로 그대로
			}
		}
		
		String msg = al0.remove(1).toString();
		System.out.println("msg:"+msg);
		System.out.println("=======[after]========");
		
		for(Object obj:al0) {
			System.out.println(obj.toString());
		}

	}

}
