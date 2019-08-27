package part1;

public class newyeset123 {

	public static void main(String[] args) {
		String s = new String("hello");
		String s2 = new String("hello");
		if(s==s2) {
			System.out.println("s와 s2의 주소값을 물어보는 것");
		}
		else {
			System.out.println("s의 주소번지값과 s2의 주소번지값이 다르다");
		}
		System.out.println(s);
		System.out.println(s2);

	}
}