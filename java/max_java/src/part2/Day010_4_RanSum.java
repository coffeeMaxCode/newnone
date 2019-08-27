package part2;

import java.util.Random;

/*
 * 클래스 구성요소
 * 변수 = field, 메소드 - method
 * 변수와 메소드는 소유하고 있는 클래스 이름
 * 자바에서 제공되는 클래스 존재
 * 변수나 메소드를 재사용 하기 위해서는 반드시 인스턴스화 필요
 * 클래스타입 변수명 = null; // 클래스 선언
 * 변수명 =  new 클래스타입(); //생성자
 */
public class Day010_4_RanSum {

	int i[] = new int[10];	// 추출되는 랜덤수
	int sum[] = new int[3];	// 양수합,음수합,0의수

	void randomValue() {
		Random ran = new Random();
		for(int k=0;k<10;k++) {		// 배열을 사용하여 초기화 할수 있음으로 for문 사용
			i[k]= ran.nextInt(21)-10;
		}
	}

	int plussum() {		//양수합
		for(int j=0; j<10; j++) {
			if(i[j]>0) {
				sum[0]+=i[j];
			}			//if end
		}				//for end
		return sum[0];
	}
	int minussum() {	//음수합
		for(int l:i) {
			if(l<0) {
				sum[1]+=l;
			}			//if end
		}				//for end
		return sum[1];
	}
	int zerosum() {		//0의수
		for(int h:i) {
			if(h==0) {
				sum[2]+=h;
			}			//if end
		}				//for end
		return sum[2];
	}

	void printRandomValue() {
		for(int k:i) {
			System.out.println(k);

		}				//for end
	}
	public static void main(String[] args) {
		Day010_4_RanSum rs = new Day010_4_RanSum();
		rs.randomValue();
		rs.printRandomValue();
		rs.sum[0] = rs.plussum();
		rs.sum[1] = rs.minussum();
		System.out.println(rs.sum[0]);
		System.out.println(rs.sum[2]);

	}						// main end

}							// class end
