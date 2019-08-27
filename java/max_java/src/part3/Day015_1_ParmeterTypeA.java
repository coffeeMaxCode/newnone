package part3;
/*
 * 배열 > 파라미터
 * void methodA(int score[]){} - 자바 중간 성적을 메소드의 파라미터로 넘기기
 * ParmeterTypeA.java
 * void methodB(String name[]){} 
 */
public class Day015_1_ParmeterTypeA {
	//점수 넣기
	void methodA(int score[]){
		//일반 for문
		for(int i=0;i<score.length;i++) {
			System.out.println(score[i]);
		}									//end for1
		//개선된 for문
		for(int i:score) {	//배열의 인덱스 사용 불가
			System.out.println(i);
		}									//end for2
	}										//end methodA
	//이름 넣기
	void methodB(String name[]){
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}									//end for1
		for(String i:name) {	
			System.out.println(i);
		}									//end for2	
	}										//end methodB
	void methodS(int score[], String name[]){
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]+"'s score : "+score[i]);
		}						//end for1
		/*		for(int, String i:score, name) {	
			System.out.println(i);
		}									//end for2		*/
	}										//end methodS
	public static void main(String[] args) {
		//배열 선언 및 초기화 처리
		int score[] = null;
		score = new int[3];
		score[0] = 70;
		score[1] = 80;
		score[2] = 90;
		//인스턴스화
		Day015_1_ParmeterTypeA pta = new Day015_1_ParmeterTypeA();
		//배열 활성화
		pta.methodA(score);

		//배열 선언 및 초기화
		String name[] = new String[] {"woody","janito","luna"};

		pta.methodB(name);

		pta.methodS(score, name);
	}							//end main

}								//end class
