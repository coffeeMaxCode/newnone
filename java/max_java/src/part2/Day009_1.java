package part2;

public class Day009_1 {
	/*for문 안에 변수를 선언하면, for문안에서만 사용
	 *초기화, 조건식, 증감연산자가 없으면 무한루프 > 서버중지
	 *반복문 사용시 - 무한루프 방지코드 필수! 
	 */
	public static void main(String[] args) {
		int i, j;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				System.out.println(i+","+j);
			}
		}

	}

}
