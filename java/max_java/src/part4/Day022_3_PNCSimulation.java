package part4;

public class Day022_3_PNCSimulation {
	
	//생성자는 메소드 오버로딩 규칙을 준수
	public static void main(String[] args) {
		Day022_1_Parent pa = new Day022_1_Parent();
		
		Day022_2_Child C = new Day022_2_Child();
		C.book = "Koran";
		System.out.println(C.book);
		
		Day022_2_Child ch = new Day022_2_Child("bible");
		System.out.println(ch.book);
		
		//기존 가르키던 객체를 재성성 하기 위해 null로 초기화
			//NullPointerException
		C= null; // 기존 참조하는 객체 Candidate 상태
		//다시 생성 - 이때 파라미터를 갖는 생성자 호출
		//생성자 내부 전역변수 book 초기화
		C = new Day022_2_Child("holy");
		System.out.println(C.book);
		
		pa.walk();
		C.walk();
		C.walk(1);
	}

}
