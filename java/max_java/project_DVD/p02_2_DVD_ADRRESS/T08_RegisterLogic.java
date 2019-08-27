package p02_2_DVD_ADRRESS;
/*
 * NullPointerException - 인스턴스화 하지 않고 선언만 되어 있는 경우
 * 그 주소번지를 사용하여 메소드를 호출하면 바로 그 때 NullPointerException 발생.
 * 
 * 인스턴스화
 * A a = new A();		:1= 다형성 X
 * A a = new B();		:2= 다형성 가능
 * A a = B.getXXX();	:3= 다형성 가능
 * 1/2 의 차이점 싱글톤 기대 가능
 * 		if(a=null){
 * 			a = new A();
 * 		}
 */
public class T08_RegisterLogic {
	//선언부에 인터페이스 생성부에 구현체 클래스 사용 : 인스턴스화
	//스프링 프레임 워크를 이용해서 MVC패턴 적용 시 > 추상클래스, 인터페이스 중심의 코딩 전개
	T05_AddressBookInterface aDao = new T04_AddressBookDao();
	
	public T03_AddressVO addressInsert(T03_AddressVO paVO) {
		
		System.out.println("RegisterLogic addressInsert 호출 성공");
		T03_AddressVO raVO = new T03_AddressVO();
//		raVO.setStatus(1);
		return raVO;
	}

}

