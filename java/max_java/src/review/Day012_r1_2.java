package review;

public class Day012_r1_2 {

	public static void main(String[] args) {

		Day012_r1_1 home1 = new Day012_r1_1();
		home1.setHome1("집에서출발");
		System.out.println(home1.getHome1());

		Day012_r1_1 home2 = new Day012_r1_1();
		home2.setHome2("학원도착");
		System.out.println(home2.getHome2());

		Day012_r1_1 home3 = new Day012_r1_1();
		home3.setHome3("학원끝");
		System.out.println(home3.getHome3());
		home3.setHome3("집으로");
		System.out.println(home3.getHome3());
	}

}
