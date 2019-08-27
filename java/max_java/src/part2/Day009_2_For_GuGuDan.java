
package part2;

public class Day009_2_For_GuGuDan {

	public static void main(String[] args) {
		int a, b, r;

		for(a=2;a<10;a++) {
			System.out.print(a+"단\n");
			for(b=1;b<10;b++) {
				r=a*b;
				System.out.print(" "+a+"X"+b+"="+r); //가로로 출력해보기
			}
			System.out.print("\n");
		}

	}

}


/*
for(a=2;a<10;a++) {

for(b=1;b<10;b++) {
	r=a*b; 
	System.out.print(a+"X"+b+"="+r);
 */