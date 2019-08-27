package part4;

public class Day022_4_0_FigureArea {
	//삼각형의 면적 구하기
	public double area(double h, double b, double z) {
		double S = h*b*z;
		System.out.println(S);
		return S;
	}
	//사각형의 면적 구하기
	public double area(double x, double y) {
		double S = x*y;
		System.out.println(S);
		return S;

	}
	//원의 면적 구하기
	public double area(double r) {
		double S;
		S=r*r*Math.PI;
		System.out.println(S);
		return 0;

	}
	
	public static void main(String[] args) {
		Day022_4_0_FigureArea f = new Day022_4_0_FigureArea();
		f.area(3, 7, 0.5);
		f.area(4, 5);
		f.area(2);
		
		Day022_4_1_Trangle t = new Day022_4_1_Trangle();
		t.area(5, 6);
		
		Day022_4_2_Square s = new Day022_4_2_Square();
		s.area(1, 2, 4);
		
		Day022_4_3_Circle c = new Day022_4_3_Circle();
		c.area(1.5);
	}

}
