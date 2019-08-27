package part1;
/*이 코드는 메인 메소드의 파라미터인 String[] args 에 대한 분석
 * 메인메소드는 클래스 안에 있는 모든 코드들 중에서 가장 높은 우선순위
 * 메인 메소드 호출 >자바가상머신(JVM- jdk1.8)
 * int메소드 > 개발자가 호출
 * 선언{}, 호출();
 * 메인메소드 호출 > 가상머신이 자동으로 함 == 콜백메소드
 * 
 * 이클립스가 없다면 컴파일 요청하는 명령어를 직접 작성
 * javac MainTest.java -> MainTest.class(기계어)
 * 실행
 * java MainTest 이순신 유승기
 * 현재 이 클래스 안에 전역변수 없음
 */
public class MainTest {
	//전역변수 선언 위치
	//지역변수 존재 = boolean
	public static void main(String[] args) {
		//파라미터에 있는 변수의 이름은 args
		//타입은 배열
		String name = args[0];//지역변수
		name=args[1];
		System.out.println(args[0]);
		System.out.println(args[1]);
	}
}
