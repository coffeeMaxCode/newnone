package quiz190529;

//Click the Exhibit button.

public class Q3_0 {
	int bootch;
	String snootch;

	public Q3_0() {   
		this("snootchy");      							//2
		System.out.print("first ");     					//8 :first 출력
	}

	public Q3_0(String snootch) {      
		this(420, "snootchy");        						//3
		System.out.print("second ");     					//7 :second 출력
	}

	public Q3_0(int bootch, String snootch) {        //4_0 :bootch, snootchy 초기화
		this.bootch = bootch;         					  //4_1 :420 값 대입
		this.snootch = snootch;           		  		  //5   :snootchy 값 대입
		System.out.print("third "); 		 			  //6   :third 출력
	}

	public static void main(String[] args) {
		Q3_0 b = new Q3_0();								//1
		System.out.print(b.snootch +" " + b.bootch);  		//9 snootchy, 420출력
	}

/*	What is the result?
A. snootchy 420 third second first
B. snootchy 420 first second third
C. first second third snootchy 420
D. third second first snootchy 420
E. third first second snootchy 420
F. first second first third snootchy 420
Answer:		D	 						*/


}
