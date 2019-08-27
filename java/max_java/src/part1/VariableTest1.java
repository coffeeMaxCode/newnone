package part1;

public class VariableTest1 {
	/*
	non-static타입의 변수는 static영역에서 사용 불가
	해결방안 = 인스턴스화
	 */
	int i=100; //전역변수, 다른 메소드에서 사용 가능
	//전역변수는 따로 초기화 불가능 한번에 선언과 초기화
	void methodA() {  //반환값이 없다 > 비어있단
		int i;// 지역변수 = 전역변수 초기화 생략 가능 > 생성자가 대신 해줌
		i=10;
		System.out.println(i); //지역변수 i
	}
	void methodA(int i) { //메소드의 파라미터 자리에 지역변수 선언 가능
		System.out.println(i); // 지역변수 초기화 하지 않음 > 전역변수 i // 정해진값출력
	}
	/*void methodA(String id, String pw) { //메소드의 파라미터 자리에 지역변수 선언 가능
		System.out.println(i);
	}
	 */
	public static void main(String[] args) { 
		VariableTest1 kk = new VariableTest1(); //인스턴스화
		kk.methodA();//메소드 호출
		kk.methodA(15); // 호출시 초기화해서 값이 정해짐 - 호출을 해서 윗 부분 활성화
		System.out.println(kk);//@abcd1234주소번지
		System.out.println(kk.i);

	}

}
