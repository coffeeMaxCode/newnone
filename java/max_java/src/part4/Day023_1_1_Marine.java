package part4;

public class Day023_1_1_Marine extends Day023_1_0_Unit {
	
	public Day023_1_1_Marine() {
		
	}
	
	void SteamPack() {
		
	}
	/*
	 * 오버라이딩은 반드시 부모 메소드와 동일해야함.(파라미터, 리턴타입)
	 * 단 접근제한자는  더 넓은 것은 가능
	 */
	@Override
	public void display() {
		System.out.println("I'm Marine");
	}

}
