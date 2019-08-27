package part5;

public class Day033_2_Exception_2 {
	/*
	 * 메소드 뒤에 throws를 붙이면 예외처리를 나를 호출한 곳에서
	 * 처리 받아라 ... 의미
	 */
	void methodA() throws Exception{
		System.out.println("methodA 호출");
		int x=5/0;
	}
	/*
	 * try..catch블록은 예외상황이 발생했을 경우에만 효과가 있다.
	 * 예외상황이 없다면 있으나 마나한 코드
	 * 
	 */
	public static void main(String[] args) {
		Day033_2_Exception_2 exc1 = new Day033_2_Exception_2();
		/*
		 * 멀티블럭으로 처리할 경우 하위 클래스에서 상위클래스 순으로 작성함
		 * 만일 같은 이름의 exception이 존재하지 않으면 더 넗은 범위(상위클래스)
		 * 가 잡는다.
		 */
		try {
			exc1.methodA();
		} catch(ArithmeticException ae) {
			System.out.println("Exception3:"+ae.toString());
			ae.printStackTrace();
		} catch(NumberFormatException ne) {
			System.out.println("Exception1:"+ne.toString());
		} catch (Exception e) {
			System.out.println("Exception2:"+e.toString());
		}

		System.out.println("종료");
	}

}