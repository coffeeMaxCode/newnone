package review;

import java.util.Scanner;

/*
 * 등비수열을 출력하는 프로그램
 */
public class Day008_r1 {

	public static void main(String[] args) {
		int f; // 초항
		int c; // 공비
		int n; // i번 반복하세요

		Scanner sc = new Scanner(System.in);
			// **Scanner IMPORT 필요 **
		System.out.println("초항의 값을 입력하세요");
		f = sc.nextInt();
		System.out.println("공비의 값을 입력하세요");
		c = sc.nextInt();
		System.out.println("몇번째 항까지 구할지 입력하세요");
		n = sc.nextInt();
		for(int i=0;i<n;i++) {

			System.out.println("등비수열 a"+n+"의 값:"+f);
			f= f*c;
		}

	}

}
