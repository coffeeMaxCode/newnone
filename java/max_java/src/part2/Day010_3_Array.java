package part2;

public class Day010_3_Array {

	public static void main(String[] args) {
		int deptnos[] = new int[3];
		deptnos[0]=10;
		deptnos[1]=20;
		deptnos[2]=30;
		for(int i=0;i<3;i++) {
			System.out.println(deptnos[i]);
		}				// for1 end
		System.out.println("===============");

		for(int num: deptnos) {	// 전체를 출력
			System.out.println(num);
		}				// for2 end
		System.out.println("===============");

		String nickName[] = new String[3];
		nickName[0] ="Janito";
		nickName[1] ="Woodi";
		nickName[2] ="Luna";
		for(String NY: nickName) {
			System.out.println(NY);
		}				// for3 end

	}					// main end

}						// class end