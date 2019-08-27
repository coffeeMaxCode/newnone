package project_Simulation;

public class MemeberSimulation3 {

	public static void main(String[] args) {
		Member mem = new Member();
		mem = new Member(10);
		mem = new Member("test","123","이순신","21354", null);
		System.out.println(mem.getMEM_ID());
		System.out.println(mem.getMEM_PW());
		System.out.println(mem.getMEM_NAME());
		System.out.println(mem.getMEM_ADDRESS());
		System.out.println(mem.getMEM_ZIPCODE());

	}

}
