package part2;

public class DAY007_1 {

	public double getTotal(int jump1,int jump2, double jump3) {
		double tot = 0.0;
		tot = jump1+jump2+jump3;
		return tot;
	}

	public double GetAverage(double tot, int inwon) {
		double avg = 0.0;
		avg=tot/inwon;
		return avg;
	}
	public static void main(String[] args) {

		DAY007_1 DAY7 = new DAY007_1();
		double tot = DAY7.getTotal(85,80,82.5);
		int inwon = 3;
		double avg = DAY7.GetAverage(tot,inwon);
		System.out.println("총점은"+tot+"입니다");
		System.out.println("평균은"+avg+"입니다");

		/*	
		int x = 2;
		int y = ++x;
			// x=2  y =3

		int x = 2;
		int y = x++;
			// x=3  y =2

		int x = 2;
		int y = --x;
			// x=2  y =1

		int x = 2;
		int y = x--;
			// x=1  y =2    */

	}

}
