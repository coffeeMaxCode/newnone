package part1;

public class taskfollow {

	public static void main(String[] args) {
		int i = 1;
		int hap= 0;
		for(i=1; i<=5; i=i+1) {
			hap = hap +i;
		}
		System.out.println("1부터 "+i+"까지의 합은" +hap);

		hap = 0 ;
		for(i=1; i<=5; i=i+2) {
			hap = hap +i;
		}
		System.out.println("1부터 "+i+"까지의 홀수 합은" +hap);
		// 연습문제  //
		double s;
		double pi=3.1416;
		int r1 = 10;
		int r2 = 20;

		s= pi*r1*r2;
		System.out.println(s);
		System.out.println("s");

	}	
}