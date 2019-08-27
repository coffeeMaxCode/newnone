package review;

public class Day012_r2_1 {
	int k=0;
	int l=0;
	double n=0.0;
	boolean b= false;

	public Day012_r2_1() {
		System.out.println("아직못가");	//디폴트값 생성자 호출
	}

	public Day012_r2_1(boolean b) {
		System.out.println("집에가자");  //파라미터 존재 생성자 호출
	}
	public void Day012s()	{
		b= true;
	}
	public void Day012f()	{
		b= false;
	}



}
