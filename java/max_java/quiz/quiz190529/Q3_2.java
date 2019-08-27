package quiz190529;

public class Q3_2 {
	String name = "김유신";
	int age = 40;
	public Q3_2() {
	}
	//this는 반드시 맨 앞에 위치/사용해야함
	public Q3_2(int age) {
		this("이순신",20);	// 3번째 생성자 호출
//		age = age;			// 변수=변수(?) > 오류
		this.age = age;		// age초기화
		System.out.println("파라미터 1개");
	}
	public Q3_2(String name, int age) {	//순서상 먼저 호출됨
		System.out.println("파라미터 2개");
	}

	public static void main(String[] args) {
		// 2번째 생성자 호출 
		Q3_2 q = new Q3_2(25);
		//25가 출력 되도록 코드를 수정 > 초기화를 하여라
		System.out.println(q.age);

	}

}
