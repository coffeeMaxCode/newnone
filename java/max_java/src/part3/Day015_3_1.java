package part3;

import java.util.Random;

/*
 * 1) 0~20 사이 임의의 수 10개 추출 > 오름차순 정렬
 * 2) 100개의 정수를 담을 수 잇는 1차배열 선언 
  		> 0~9사이 임의의 수 추출  > 각숫자의 분포도 출력
 */
public class Day015_3_1 {

	int Q[] = new int [10];	

	public void randomplay() {
		Random R = new Random();

		for(int i=0; i<10; i++) {
			Q[i] = R.nextInt(21);
		}								//end for1
	}									//end methodA

	public void arraynum() {
		int temp;
		for(int k=0; k<Q.length; k++) {
			for(int m=k+1; m<Q.length;m++) {
				if(Q[k] > Q[m]) {
					temp = Q[k];
					Q[k] = Q[m];
					Q[m]= temp;
				}							//end if
			}							//end for2
		}								//end for1
	}									//end methodB

	public void  printnum() {
		for(int i=0;i<10;i++) {
			System.out.println(Q[i]);
		}								//end for
	}										//end methodC

	public static void main(String[] args) {

		Day015_3_1 D15 = new Day015_3_1();

		System.out.println("Quiz 1");

		D15.randomplay();
		D15.arraynum();
		D15.printnum();

		System.out.println("Quiz 2");

	}									//end  main

}										//end class
