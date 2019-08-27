package part4;

public class Day022_2_Child extends Day022_1_Parent {
	String book = "vible";
	//생성자는 메소드 오버로딩 규칙을 준수
	public Day022_2_Child() {
		System.out.println("C 디폴트 생성자");
	}
	public Day022_2_Child(String book) {
		this.book = book;
		System.out.println("C-S 디폴트 생성자");
	}
	
	//오버라이딩
	public void walk() {
		System.out.println("Parent're wlaking now!!");
	}
	//오버로딩
	public void walk(int i) {
		System.out.println("Parent're wlaking now!i");
	}
	
	public void run() {
		System.out.println("Children's running now");
	}
}
