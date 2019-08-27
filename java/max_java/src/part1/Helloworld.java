package part1;
// 클래스
// 클래스 이름 = Helloworld
public class Helloworld {
	//Ctrl+s 저장 된 후 즉시 컴파일 실행 - eclipse
	//한글에서 코딩을 하면, 저장은 되나 컴파일이 되지 않기 때문에 효용성 없음
	public static void main(String[] args) {
		// 메인 메소드 
		// 뒤에 {} 것을 나타내는 모든 부분이 클래스, 클래스 {} 안쪽 부분이 메소드
		// 명사형 사용 가능
		// 변수 선언하기
		// 대입연산자 '='  같다 '=='
		// true 참  Cf) 1==1 참, true

		int sal= 800;
		//윗줄은 변수를 선언했고 대입연산자를 사용해서 그 변수에 800이라는 값을 저장함
		//정수를 담을 때는 반드시 int 타입을 사용
		//변수 sal = 800 으롤 정의
		sal = 300;
		//변수 sal = 300 으로 재정의

		// int == 타입 == 정의, sal == 변수 == 저장공간 확보
		// 자바에서는 다양한 타입 제공
		// 오라클에서 저장된 정보가 여러가지임
		// SELECT ename, sal FROM emp
		// SELECT == 검색

		System.out.println(sal);
		//윗줄은 변수 sal 안에 담겨있는 숫자 출력해보기
		//System == PC를 뜻함
		//out == 명사형, 출력을 내보냄을 나타내는 명사형
		//println() == 메소드, 화면에 출력 가능 =>300 출력
		System.out.println(sal+300);
		//sal값에 300을 더한 뒤 출력 == 600출력
		System.out.println(sal);
		//sal값 출력 == 300  출력

		System.out.println(500);
		//sys Ctrl+SpaceBar > sysout : 후에 println 안에 출력값 넣기
		//오른쪽 클릭 run as > 1 java application > 저장 및 컴파일 > 출력된 값 확인하기


		//int a;
		// 위 상황은 a 는 존재하지만 아직 지정되지 않은 값
		//int name="SMITH";
		// 위 상황은 타입이 맞지 않기 때문에 정의되지 않는 경우 ; name값이 문자임

	}

}