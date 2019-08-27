package part1;

//메소드 안에서 메소드 선언 불가
//메소드 안에서 다른 메소드 호출 가능

/* 예시 - 평균을 구한다. 총점을 구하는 메소드 선언
 * 입력받는 점수는 파라미터로 선언
 * 총점을 계산하면 그 결과는 리턴타입
 * 사용자와 프로그램 사이 소통
 */
public class car {
	//메소드 선언위치
	String carName= "2017형프라이드";
	//전역변수는 생성자가 초기화, 지역변수는 생성자가 초기화 불가

	int speedUP() {
		int speed = 0;
		speed = speed +1;
		String carName= "2018형프라이드";
		System.out.println(carName);
		return speed;
	}
	//메소드 선언시 리턴타입 자리에 void 쓰면 그 메소드안에  return 예약어  안씀
	void volumdown(int noise) {
		System.out.println(carName);
		String carName = "2019형프라이드";
		System.out.println(carName);
		noise = noise -1;
	}
	public static void main(String[] args) {
		car myCar = new car();
		myCar.speedUP();
		myCar.volumdown(0);
		System.out.println(myCar);
		System.out.println(myCar.carName);

	}

}
