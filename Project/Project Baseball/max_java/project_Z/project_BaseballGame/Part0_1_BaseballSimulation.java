package project_BaseballGame;

public class Part0_1_BaseballSimulation {

	public static void main(String[] args) {
		Part0_0_BaseballGame fb = new Part0_0_BaseballGame();

		for(int i=0; i<10; i++) {
			fb.ranCom();
			System.out.println(fb.com[0]+","+fb.com[1]+","+fb.com[2]);
		}
	}

}
