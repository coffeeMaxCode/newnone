package quiz190529;
/*
 * Given:
11. Float pi = new Float(3.14f);
12. if(pi>3) {
13. System.out.print("pi is bigger than 3. ");
14. }
15. else {
16. System.out.print("pi is not bigger than 3. ");
17. }
18. finally {
19. System.out.println("Have a nice day.");
20. }

‘What is the result?
A. Compilation fails.
B. pi is bigger than 3.
C. An exception occurs at runtime.
D. pi is bigger than 3. Have a nice day.
E. pi is not bigger than 3. Have a nice day.

Answer:   A
 */

/*
 * finally
 */
public class Q7_0 {

	public static void main(String[] args) {

		Float pi = new Float(3.14f);
//		if(pi>3) {										// if   > try
//			System.out.print("pi is bigger than 3. ");
//		}
//		else {											// else > catch
//			System.out.print("pi is not bigger than 3. ");
//		}
//		finally {						// 컴파일 에러
//			System.out.println("Have a nice day.");
//		}

		// 수정문
		try{
			if(pi>3) {									// if조건 성립
				System.out.print("pi is bigger than 3. ");		// 출력
			}else {											// else > catch
				System.out.print("pi is not bigger than 3. ");
			}
			}catch (Exception e) {
				System.out.print("pi is not bigger than 3. ");
			}			finally {
				System.out.println("Have a nice day.");		// 출력
			}		

		

	}
}
