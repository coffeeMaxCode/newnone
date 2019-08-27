package part3;

public class Day015_2_ReturnTypeA {

	int[] methodD(){
		int number[] = {10, 20, 30};
		return number;
	}

	public static void main(String[] args) {

		Day015_2_ReturnTypeA rta = new Day015_2_ReturnTypeA();
		int number[] = rta.methodD();
		// 지역변수로 선언된 배열도 다른 메소드 영역에서 사용 가능
		//리턴타입 역활
		for(int num:number) {
			System.out.println(num);
		}
	}

}
