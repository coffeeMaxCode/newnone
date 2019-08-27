package part2;
/* fizzbuzz
 * 5의 배수이면 fizz, 7의 배수이면 buzz, 5와 7의 공배수이면 fizzbuzz 출력
 */
public class Day009_4_Switch_FizzBuzz {

	public static void main(String[] args) {
		int m=1;
		int y;

		while(m<101) {
			y=m%35;
			switch(y) {				//switch1
			case 0:System.out.println("FizzBuse");
			break;
			default : y=m%5;
			switch(y) {		// switch2
			case 0:System.out.println("Fizz");
			break;
			default : y=m%7;
			switch(y) {	// switch3
			case 0:System.out.println("Buzz");
			break;
			default : System.out.println(m);
			break;
			}			// switch3 end
			}		// switch2 end
			}		// switch1 end	
			++m;
		}			// while end
	}					// main end

}						// class end
