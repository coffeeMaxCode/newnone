package quiz190529;

import javax.swing.JButton;

/*Given:
55. int []x= {1,2,3,4,5};
56. int y[] = x;
57. System.out.println(y[2]);

Which is true?  //사실인 것?
A. Line 57 will print the value 2.
B. Line 57 will print the value 3.
C. Compilation will fail because of an error in line 55.
D. Compilation will fail because of an error in line 56.

답 :  B
 */
public class Q1 {

	public static void main(String[] args) {
		int []x= {1,2,3,4,5};
		int y[] = x;
		System.out.println(y[2]);
//----------------------------------------------------------//
		int x1,y1,z1;
		int []a,b,c;	//배열 기호가 앞에 있으면 모두 배열
//		b=10;	//오류
		c=new int [20];
		int a1[],b1,c1;	//배열 기호가 뒤에 있으면 당사자 하나만 배열
		b1=10;
		c1=20;
		int []xz= {1,2,3,4,5};
		int yz[] = xz;
		System.out.println(yz[2]);
//----------------------------------------------------------//
		JButton jbtn_save = new JButton("Save");
		JButton	jbtn_im	  = jbtn_save;
		System.out.println(jbtn_im.getText());	//Save 받아옴
	}

}
