package part2;
/*
 * 등비수열.
a1항에서 a7항까지의 수열을 출력
a1 a2 a3  a4  a5   a6  a7
2  6  18  54  162  486 1458
 */
public class Day008_4_GeometricSequence {

	public static void main(String[] args) {
		int a;
		int b=2; // 초항의 값을 넣으시오
		int n=1;
		for(a=2;n<=7;n++) {
			System.out.println("등비수열 a"+n+"의 값:"+b);
			b=a*3;
			a=b;
		}

	}

}
