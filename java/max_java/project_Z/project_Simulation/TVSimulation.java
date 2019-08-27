package project_Simulation;
/*
 * 인스턴스화 가능
 * 같은 타입 여러번 했을 때의 차이점
 * 생성자가 호출되는 코드
 * 생성자가 하는 역할, 호출 가능  
 */
public class TVSimulation {

	public static void main(String[] args) {
		TV kTV = new TV();
		TV bTV = new TV();
		TV mTV = new TV();

		mTV.onoff = true;
		TV himTV = null;
		himTV = new TV(true);

	}

}
