package part2;

public class Day009_2_While_GuGuDan {

	public static void main(String[] args) {
		int a, b, r;

		a=2;

		while(a<10) {
			b=1;
			while(b<10) {
				r=a*b;
				System.out.println(" "+a+"X"+b+"="+r);
				b++;
			}
			a++;
		}
	}

}
