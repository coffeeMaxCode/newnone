package part4;

public class Day024_OuterClass {
	int i = 0;
	
	public Day024_OuterClass() {
		System.out.println(i);
	}
	
	class Inner{
		//내부클래스
		int x;
		void methodA() {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {		
		Day024_OuterClass outer = new Day024_OuterClass();
		
//		Day024_OuterClass.Inner in = new Day024_OuterClass().new Inner();
		
	}

}
