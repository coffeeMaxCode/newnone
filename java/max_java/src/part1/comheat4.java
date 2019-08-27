package part1;

import java.util.Scanner;

public class comheat4 {

	public static void main(String[] args) {
		System.out.println("당신의점수는");
		Scanner scan = new Scanner(System.in);
		int jumsu = scan.nextInt();
		System.out.println("입력한점수는"+jumsu);
		char hakjum = 'z';
		if((jumsu>100)||(jumsu<0)) {
			hakjum = 'U';
			System.out.println("입력한점수는"+jumsu+"입니다");
			System.out.println("0~100사이 점수를 입력해주세요");
		}else if((jumsu>=90)&(jumsu<=100)) {
			hakjum = 'A';
		}else if(jumsu>=80) {
			hakjum = 'B';
		}else if(jumsu>=70) {
			hakjum = 'C';
		}else if(jumsu>=60) {
			hakjum = 'D';
		}else if(jumsu>=50) {
			hakjum = 'E';
		}else { 
			hakjum = 'F';
		}
		System.out.println("당신의학점은"+hakjum);
	}
}
