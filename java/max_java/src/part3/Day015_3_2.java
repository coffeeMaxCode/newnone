package part3;

import java.util.Random;

/*
 * 1) 0~20 사이 임의의 수 10개 추출 > 오름차순 정렬
 * 2) 100개의 정수를 담을 수 잇는 1차배열 선언 
  		> 0~9사이 임의의 수 추출  > 각숫자의 분포도 출력
 */
public class Day015_3_2 {

	int Q[] = new int [100];
	int C[] = new int [10];
	int k=0;

	public void randomplay() {
		Random R = new Random();

		for(int i=0; i<100; i++) {
			Q[i] = R.nextInt(10);
		}								//end for
	}									//end randomplay

	public void countnum() {
		for(int i=0; i<100;i++) {

			int k= Q[i];

			if(Q[i]==k) {
				C[k]++;
			}
		}
	}									//end countnum	

	public void printresult() {
		for(int l=0; l<10;l++) {
			System.out.println("C["+l+"] : "+C[l]+"회");
		}
	}									//end printresult

	public static void main(String[] args) {

		Day015_3_2 Q2 = new Day015_3_2();

		Q2.randomplay();
		Q2.countnum();
		Q2.printresult();

	}

}
