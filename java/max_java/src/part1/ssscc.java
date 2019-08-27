package part1;

public class ssscc {

	public static void main(String[] args) {

		int i = 0, j = 1;
		if((i++ == 1) && (j++ == 2)) {
			i = 42;
		}
		System.out.println("i = " + i + ", j = " + j);;

	}
}

// |연산자가 한개든 두개이든 실행문이 실행되고 안되고는 동일
// 한개 일때는 | 두번재 조건을 따짐, 두번째 조건에 증감연산자가 존재하면 계산에 영향을 줌
// 두개 일때는 || 첫번째 조건만 따짐

// 조건연산자 if문 대신 사용할 수 있다