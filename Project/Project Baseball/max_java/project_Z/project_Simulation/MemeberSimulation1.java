package project_Simulation;

public class MemeberSimulation1 {

	public static void main(String[] args) {
		Member mem = new Member();
		/*
		 * Member class 에서는 여러가지 변수가 선언되어있음 // 선언만 하고, 초기화X
		 * 즉, 어떠한 정보도 가지고 있지 않은 상태
		 * 어떠한 정보를 초기화 해주어야  값을 꺼낼 수 있음
		 */
		String MEM_ID = mem.getMEM_ID();
		System.out.println("ID:"+MEM_ID);
		mem.setMEM_ID("test");
		System.out.println("ID:"+mem.getMEM_ID());
		/*아래서 호출한  MEM_ID = 13번에서 선언된 변수
		  MEM_ID변수에 값을 담을 수 있는 setter메소드가 호출되기 전이므로 null		*/
		System.out.println("ID:"+MEM_ID);			// null 출력
		/*아래 MEM_ID는 변수이름은 동일하지만, Member calss에서 선언된 전역변수
		 * 접근 자체가 private에서 왔으므로 변수 호출이 불가 - 문법에러 발생		*/
//		System.out.println("ID:"+mem.MEM_ID());		// null 출력

	}

}
