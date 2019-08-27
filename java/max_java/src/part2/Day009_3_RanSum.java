package part2;

import java.util.Random;

/* -10~ +10 까지 중 100개를 임의로 추출
 * 그 sum을 구하기
 */
public class Day009_3_RanSum {

	public static void main(String[] args) {
		Random r = new Random();// Random함수
		// 0~20 . -10~+10
		int t;
		int sum=0;
		int sump=0;
		int summ=0;
		int zero=0;
		System.out.println("추출한 수들");
		for(t=1;t<=100;t++) {
			int i = r.nextInt(21)-10;
			sum+=i;
			System.out.print(i+",");

			if(i>0) {
				sump+=i;
			}else if(i<0) {		// if end
				summ+=i;
			}else {				// else if end
				zero++;
			}					// else end
		}		// for end
		System.out.println("\n양수 난수 합의 값은"+sump); // 난수 총합
		System.out.println("음수 난수 합의 값은"+summ); // 난수 총합
		System.out.println("난수 총 합의 값은"+sum); // 난수 총합
		System.out.println("0은 총"+zero+"번 추출"); // 난수 총합


	}			// main end

}				// class end
