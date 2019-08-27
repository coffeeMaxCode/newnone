package part2;

public class Day010_1_While {

	public static void main(String[] args) {
		int num =1;
		int sum = 0;

		while(num<=10) {
			sum+= num;
			num++;
		}			//while end
		System.out.println("1부터 10까지의 합:"+sum);
	}				// main end

}					// class end