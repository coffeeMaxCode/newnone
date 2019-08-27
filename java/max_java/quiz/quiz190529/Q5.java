package quiz190529;
/*
 * Given:
11. public static void main(String[] args) {
12. Integer i = new Integer(1) + new Integer(2);
13. switch(i) {
14. case 3: System.out.println(”three”); break;
15. default: System.out.println(”other”); break;
16. }
17. }

‘What is the result?
A. three
B. other
C. An exception is thrown at runtime.
D. Compilation fails because of an error on line 12.
E. Compilation fails because of an error on line 13.
F. Compilation fails because of an error on line 15.

Answer:  A
 */
/*
 * 오토박싱 & switch
 * switch에서 break 사용 필수
 */
public class Q5 {
	public static void main(String[] args) {
//		 Q5 q5 = new Q5();
//		 int i = 10;
//		 Integer i2 = new Integer(100);
//		 i = i2;
//		 System.out.println(i);

		Integer i = new Integer(1) + new Integer(2);		//i == 3
		switch(i) {										//i == 3
		case 3: System.out.println("three"); break;		// three 출력 break
		default: System.out.println("other"); break;
		}
	}
}
