package part2;
/*
 * 피보나치  수열의 규칙을 알아보고 a1~a10항을 출력
 * 피보나치 수열  sum(a[n])  = a[n-1]-1
 * a[n+1]=a[n+2]-a[n] // a[n+2] = a[n+1] + a[n]
 */
public class Day008_3_Fibonacci {

	public static void main(String[] args) {
		int m=0; // n
		int n=1; // n+1
		int k; // n+2
		int i;

		for(i=1; i<=10; i++) {
			k=m+n;
			System.out.println(m+"은 피보나치 수열의 수이다");
			n=m;
			m=k;
		}
	}
}
