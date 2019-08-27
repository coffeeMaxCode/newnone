package part3;

import java.util.Random;

/*
 * 1) 0~20 사이 임의의 수 10개 추출 > 오름차순 정렬
 * 2) 100개의 정수를 담을 수 잇는 1차배열 선언 
  		> 0~9사이 임의의 수 추출  > 각숫자의 분포도 출력
 */
public class Day015_3_0 {

	int[] methodA(int Q[]) {
		Random R = new Random();

		for(int i=0; i<10; i++) {
			Q[i] = R.nextInt(21);
		}								//end for1
		return Q; 
	}									//end methodA

	int[] methodB(int Q[]) {
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
		return Q; 
	}									//end methodB

	void methodC(int a[]) {
		for(int i=0;i<10;i++) {
			System.out.println(a[i]);
		}								//end for
	}										//end methodC

	public static void main(String[] args) {

		Day015_3_0 D15 = new Day015_3_0();

		// 리턴 값을 받아 주기 위해서 배열Q 선언
		int Q[] = new int [10];		

		D15.methodA(Q);
		D15.methodB(Q);
		D15.methodC(Q);


	}									//end  main

}										//end class
