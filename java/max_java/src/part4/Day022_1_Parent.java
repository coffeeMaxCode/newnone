package part4;

public class Day022_1_Parent {
	public Day022_1_Parent(){
		System.out.println("P 디폴트 생성자 호출");
	}
	
	int leg;
	
	public Day022_1_Parent(int leg){
		this.leg = leg;
	}
	
	
	public void walk() {
		System.out.println("We're wlaking now");
	}

}
