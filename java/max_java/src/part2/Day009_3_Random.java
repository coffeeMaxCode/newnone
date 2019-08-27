package part2;

import java.util.Random;
import java.util.Scanner;

/*
 * 0~9사이 난수 1개를 정하여 그 숫자를 맞추어라
 * 5번의 기회, 실패하면 loser, 힌트는 up, down
 */
public class Day009_3_Random {

	public static void main(String[] args) {

		Random r = new Random();// Random함수 > 난수 설정을 위해서 import
		//인스턴스화 - 변수 r == 인스턴스 변수
		Scanner sc = new Scanner(System.in); // 스캐너 import하기

		int i = r.nextInt(10); // i == 난수 설정 10미만
		System.out.println("0~9사이의 난수가 설정되었습니다.");

		int t;  // t == 횟수  
		for(t=5;t>0;t--) {
			System.out.println("남은 기회는"+t+"\n무엇일까요?");
			int k = sc.nextInt(); // k == 대답

			if(k==i){
				System.out.println("Winner!");
				break;	// 맞추면 for문 탈출
				//System.exit(0); // == 가상머신 종료ㅜ  
			}else if(k<i) {
				System.out.println("up");	
			}else if(k>i) {
				System.out.println("down");	
			}
			if(t==1) {
				System.out.println("L.O.S.E.R");
			}

		}
		sc.close();			//스캐너 닫기
	}
}	