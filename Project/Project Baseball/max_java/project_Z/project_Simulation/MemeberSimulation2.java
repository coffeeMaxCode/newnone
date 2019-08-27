package project_Simulation;
/*
 * 2007년 다음에서 발표한 자료에 따르면 1초당 2720명이 접속을 시도
 * 이중 500명만 로그인을 할 경우, 이 500건의 정보를 따로 관리해야함
 * 그러기 위해서 같은 테이블에서 읽어온 정보이지만 자바단에서 식별이 가능해야함
 * 타입은 같지만 객체 생성을 500번 했을 경우 서로 다른 객체로 인식되어 각각 다른 아이디를 기억함
 * 변수의 장애 = 같은 타입 1개만!
 * mem*패턴 설계 = 서로 다른 타입 n개를 담을 수 있음
 */
public class MemeberSimulation2 {

	public static void main(String[] args) {
		Member mem1 = new Member();
		mem1.setMEM_ID("Luna");
		Member mem2 = new Member();
		mem2.setMEM_ID("Janitoo");
		Member mem3 = new Member();
		mem3.setMEM_ID("Woody");

		System.out.println("ID:"+mem1.getMEM_ID());
		System.out.println("ID:"+mem2.getMEM_ID());
		System.out.println("ID:"+mem3.getMEM_ID());

		Member mema = new Member();		//선언이 되었으므로 이후 선언 중복 피하기
		mema.setMEM_ID("Luna");
		System.out.println("ID:"+mema.getMEM_ID());
		mema = new Member();
		mema.setMEM_ID("Janitoo");
		System.out.println("ID:"+mema.getMEM_ID());
		mema = new Member();
		mema.setMEM_ID("Woody"); 
		System.out.println("ID:"+mema.getMEM_ID());

	}

}
