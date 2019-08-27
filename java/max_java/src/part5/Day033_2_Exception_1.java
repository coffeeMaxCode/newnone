package part5;

public class Day033_2_Exception_1 {
	
	void methodA() {
		System.out.println("methodA 호출");
	}
	/*
	 * try..catch블록은 예외상황이 발생했을 경우에만 효과가 있다.
	 * 예외상황이 없다면 있으나 마나한 코드
	 * 
	 */
	public static void main(String[] args) {
		Day033_2_Exception_1 exc1 = null;
		try {
			exc1 = new Day033_2_Exception_1();
			exc1.methodA();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("다른 코드들.....");
	}

}
