package quiz190529;
/*
 * Given:
1. public class A {
2. public void doit() {
3. }
4. public String doit() {  
5. return “a”;
6. }
7. public double doit(int x) {
8. return 1.0;
9. }
10.}
What is the result?
A. An exception is thrown at runtime.
B. Compilation fails because of an error in line 7.
C. Compilation fails because of an error in line 4.
D. Compilation succeeds and no runtime errors with class A occur.

Answer: C
 
 * 자바는 같은 이름의 메소드를 중복 정의 가능
 * 전제조건 = 반드시 메소드 이름이 같을 때만 고려
 * 오버로딩이 되지 않음
 * 파라미터의 갯수가 다르거나 타입이 다르면 중복 선언되어 오류
 * 리턴타입은 메소드 오버로딩에 영향 없음
 * 접근 제한자가 있고 없고는 영향 없음
 */
public class Q2 {
	public void doit() {		//이름 동일, 파라미터,타입 없음
	}
	public String doit(int a, int b) {  	//이름 동일, 파라미터,타입 없음
		return "a";							//int타입 파라미터 개수 다름
	}
	public String doit(double k) {  		//다른 타입
		return "a";	
	}
	public double doit(int x) {
		return 1.0;
	}


}
