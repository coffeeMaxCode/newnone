package part4;
/*자바의 특징 
- 재사용성과 다형성
인스턴스화 할 때 선언부와 생성부의 이름이 다를 수 있음
Super[선언부] sup = new Sub[생성부]();
생성부에 오는 클래스이름으로 객체 생성
*/
public class Day022_5_3_SupNSu {

	public static void main(String[] args) {
		Day022_5_1_Sup sup1 = new Day022_5_1_Sup();
		//정의 할 때, 가져온 클래스의 메소드만 사용 가능
		Day022_5_1_Sup sup2 = new Day022_5_2_Sub();
		//선언부의 타입과 생성부의 타입이 다를 수 있음 = 다형성 기대 가능
		sup1.methodA();
		sup2.methodA();
//		sup1.methodB();
//		sup2.methodB();
//		
		//선언부 타입과 생성부 타입이 같으면 다형성 불가
		Day022_5_2_Sub sub = new Day022_5_2_Sub();
		sub.methodA();
		sub.methodB();

	}

}
