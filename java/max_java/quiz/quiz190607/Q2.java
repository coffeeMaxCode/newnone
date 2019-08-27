package quiz190607;
/* 클래스 형변환
Given:
interface Foo {}
class Alpha implements Foo { }
class Beta extends Alpha {}
public class Delta extends Beta {
public static void main( String[] args) {
Beta x = new Beta();
// line 16 : insert code here
}
}
Which code, inserted at line 16, will cause a java.lang.ClassCastException?

A. Alpha a = x;
B. Foo f= (Delta)x; 
C. Foo f= (Alpha)x;
D. Beta b = (Beta)(Alpha)x;

Answer : 
*/

interface Foo {}
class Alpha implements Foo { }
class Beta extends Alpha {}

public class Q2 extends Beta {
	public static void main( String[] args) {
		Beta x = new Beta();
		// insert code here
	}
}


