package quiz190607;

/*Given:
 public interface Status {
  [???]  int MY_VALUE = 10;  //상수 설정
 }
Which three are valid on [???]? (Choose three.)

A. final
B. static
C. native
D. public
E. private
F. abstract
G. protected

Answer: D A B : public final static
*/

interface Status {
	int MY_VALUE = 10;
	final int TEST1 = 0;
	final static double TEST2 = 50.0;
	public final static String NAME = "이순신";
}

public class Q1 implements Status {

	public static void main(String[] args) {
		Status sta = new Q1();
		System.out.println(sta.MY_VALUE);
		System.out.println(sta.TEST1);
		System.out.println(sta.TEST2);
		System.out.println(sta.NAME);
	}

}
