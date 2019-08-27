package quiz190529;
/*
 * Given:
11. public void testIfA() {
12. if(testIfB(”True”)) {
13. System.out.println(”True”);
14. } else {
15. System.out.println(”Not true”);
16. }
17. }
18. public Boolean testIfB(String str) {
19. return Boolean.valueOf(str);
20. }

What is the result when method testIfA is invoked?  //
A. True
B. Not true
C. An exception is thrown at runtime.
D. Compilation fails because of an error at line 12.
E. Compilation fails because of an error at line 19.

Answer:  A
 */
public class Q4 {
	public void testIfA() {						//4
		if(testIfB("True")) {					//5	: True = str 값 대입
			System.out.println("True");			//6 : 출력
		} else {
			System.out.println("Not true");
		}
	}
	public Boolean testIfB(String str) {
		return Boolean.valueOf(str);	// str = 'True' 값 받아
	}

	public static void main(String[] args) {	//1
		Q4 q4 = new Q4();					//2
		q4.testIfA();						//3
	}

}
