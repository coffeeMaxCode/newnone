package part2;

import java.util.Random;

public class Day010_2_DoWhile {

	public static void main(String[] args) {
		int a = -1;
		int b = -1;
		int c =-1;
		Random ran = new Random();
		a = ran.nextInt(10);
		do {
			b = ran.nextInt(10);
		}while(a==b);				// do while1 end
		do {
			c = ran.nextInt(10);
		}while((a==c)|(b==c));		// do while2 end

		System.out.println(a+","+b+","+c);

	}							// main end
}								// class end