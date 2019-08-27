package part4;

public class Day022_4_1_Trangle extends Day022_4_0_FigureArea {


	public double T_area(double h, double b, double z) {
		z = 1/2;
		System.out.println("Trangle");
		double TS = h*b*z;
		System.out.println(TS);
		return TS;
	}

}
