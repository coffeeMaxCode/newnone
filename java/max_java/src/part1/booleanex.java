package part1;
//메소드 선언
public class booleanex {
	static void methodA(boolean isOk){
		System.out.println(isOk);
	}
/*
메소드 : 변수 = isOk, 타입 boolean
메소드 선언 시, 파라미터(매개변수) 추가 가능
메소드 선언 시 파라미터 자리에 변수 선언 가능
파라미터자리에 사용자가 입력한 값을 받는 변수가 됨
선언한 메소드는 클래스 안에서 어디서든 호출 가능
메소드 밖에서 호출 불가능
main 메소드에서 호출한 이유는 메인 메소드가 entry point이기 때문
클래스 안에서 작성된 코드 중 가장 먼저 실행되는 코드
다른 코드는 호출하기 전까지 가지고 있지만 실행 절대 안됨
실행하도록 하려면 반드시 메소드를 호출해야함
호출 시, 반드시 파라미터 갯수와 타입을 맞추어야함
메인 메소드에서 if문을 사용한 이유는 boolean타입을 언ㅇ제사용하는지 보여주는 것
if문은 조건을 만족했을 때, 좌중괄호와 우중괄호 안에 있는 코드를 실행
만일 거짓이라면 그안에 있는 코드는 실행 기회를 갖지 못함
클래스안 다른 코드들은 얼마든지 작성할 수 있음, 언제나 실행되는 것은 아님
반드시 불러주어야 실행되는 것	*/

	//메소드 실행
	public static void main(String[] args) {
		methodA(true); // 타입을 맞추퉅
		if(1==1) // 괄호 안 boolean타입
		{
			System.out.println("참");
		}


	}

}
