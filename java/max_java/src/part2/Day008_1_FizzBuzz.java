
package part2;
/* fizzbuzz
 * 5의 배수이면 fizz, 7의 배수이면 buzz, 5와 7의 공배수이면 fizzbuzz 출력
 */
public class Day008_1_FizzBuzz {

	public static void main(String[] args) {
		int i = 1;
		//for구문	
		for(i=1; i<=100;i++) {
			if(i%35==0) {
				System.out.println("fizzbuzz");
			}else if(i%5==0) {
				System.out.println("fizz");
			}else if(i%7==0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
		}
		//while 구문		
		/*		while(i<=100) {
			if(i%35==0) {
				System.out.println("fizzbuzz");
			}else if(i%5==0) {
				System.out.println("fizz");
			}else if(i%7==0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
			i++;
		} */
	}

}
