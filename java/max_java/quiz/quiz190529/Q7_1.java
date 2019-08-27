package quiz190529;
/*
 * finally
 */
public class Q7_1 {
	static void methodA() {
		int[]a = new int[] {1,2};
		int b = 5;
		try {
			b= a[1] +b;					// 오류 진행시 catch 로 넘어가 진행
			System.out.println(b);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {						// finally : try-catch문 마지막에 위치
			System.out.println("예외와 상관 없이 무조건 실행");
		}
		System.out.println("반드시 실행되어야 할 코드 존재");
	}

	public static void main(String[] args) {
		methodA();

			// 수정문
		Float pi = new Float(3.14f);
		try{
			if(pi>3) {									        // if조건 성립
				System.out.print("pi is bigger than 3. ");		// 출력
			}else {
				System.out.print("pi is not bigger than 3. ");
			}
		}catch (Exception e) {
			System.out.print("pi is not bigger than 3. ");
		}
		finally {
			System.out.println("Have a nice day.");		// 출력
		}		

	}

}