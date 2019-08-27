package quiz190529;
/*
 * Click the Exhibit button.
11. public class Bootchy {
12. int bootch;
13. String snootch;
14.
15. public Bootchy() {  // 
16. this(”snootchy”);   // 								//2
17. System.out.print(”first “);  // 					//8
18. }
19.
20. public Bootchy(String snootch) {  // 3
21. this(420, “snootchy”);  // 4 :						//3
22. System.out.print(”second “);  // 					//7
23. }
24.
25. public Bootchy(int bootch, String snootch) {  // 5
26. this.bootch = bootch;  // 6 : 						//4
27. this.snootch = snootch;  // 7 : 					//5
28. System.out.print(”third “);  // 8 : 				//6
29. }
30.
31. public static void main(String[] args) {
32. Bootchy b = new Bootchy();							//1
33. System.out.print(b.snootch +“ “ + b.bootch);  //	//9
34. }
35. }
What is the result?
A. snootchy 420 third second first
B. snootchy 420 first second third
C. first second third snootchy 420
D. third second first snootchy 420
E. third first second snootchy 420
F. first second first third snootchy 420
Answer:
 
 * 생성자와 this
 * this	  : 자기 자신의 주소번지
 * this() : 자기 자신 생성자 호출 
 * 생성자도 메소드 오버로딩 규칙을 따름
 * 리턴타입이 있다면 ☆ 메소드	// 생성자는 리턴타입 없음
 */
public class Q3_1 {
	String name = "김유신";
	int age = 40;
	public Q3_1() {
	}
	//this는 반드시 맨 앞에 위치/사용해야함
	public Q3_1(int age) {
		this("이순신",20);	// 3번째 생성자 호출
		System.out.println("파라미터 1개");
	}
	public Q3_1(String name, int age) {	//순서상 먼저 호출됨
		System.out.println("파라미터 2개");
	}

	public static void main(String[] args) {
		// 2번째 생성자 호출 
		new Q3_1(20);
		Q3_1 q3 = new Q3_1(25);
		//생성자를 호출했을 때, 전역변수 age가 초기화 됨/안됨 = 안됨 = 생성자 내의 지역변수
											//초기화 되면 25, 안되면 40 출력 될 것
		System.out.println(new Q3_1(25).age);
		//현재 객체 3개 생성 - 60, 61, 64

	}

}
