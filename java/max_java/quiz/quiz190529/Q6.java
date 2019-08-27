package quiz190529;
/*
 * Given:
11. public static void main(String[] args) {
12. String str = “null”;
13. if (str == null) {
14. System.out.println(”null”);
15. } else (str.length() == 0) {  //else if
16. System.out.println(”zero”);
17. } else {
18. System.out.println(”some”);
19. }
20. }

‘What is the result?
A. null
B. zero
C. some
D. Compilation fails.
E. An exception is thrown at runtime.

Answer:  D
 */
/*
 * if, else if, else 차이점 비교
 * if			주어진 조건
 * else if		주어진 조건
 * else			다른 조건이 만족 하지 않으면
 */
public class Q6 {

	public static void main(String[] args) {
		String str = "null";
		if (str == null) {
			System.out.println("null");
//		} else (str.length() == 0) {  	// else는 조건이 없음 / else if 조건 있음
//			System.out.println("zero");
		} else if (str.length() == 0) { // 수정
			System.out.println("zero");
		} else {
			System.out.println("some");
		}
	}
}
