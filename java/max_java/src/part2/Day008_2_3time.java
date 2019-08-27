package part2;

import java.util.Scanner;
/*
 * 두 정수를 입력받아서 두 정수 사이 3의 배수의 개수를 출력 [경계값 제외]
 */
public class Day008_2_3time {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 정수를 입력하세요");
		int a = sc.nextInt();

		System.out.println("두번째정수를 입력하세요");
		int b = sc.nextInt();

		sc.close();			//스캐너 닫기

		int k;//3의 배수 개수 담기
		k=0;
		k = a/3 - b/3;

		if(b%3==0) {
			k = Math.abs(k)-1;
		}

		System.out.println("입력한 두 정수는"+a+" 그리고 "+b+"입니다.");
		System.out.println("두 정수사이 3의배수 개수는"+Math.abs(k)+"개이다.");	
	}
}