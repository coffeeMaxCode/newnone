package part2;

public class Day009_4_switch_Base {

	public static void main(String[] args) {
		int i=3;
		int j=2;
		switch(i){
		//case 1: 
		//break;
		case 2: ++i;
		break;
		case 3: ++i;
		//break;
		case 4: ++i;
		//break;
		default: j+=i;
		break;
		}		// switch end
		System.out.println(j+","+i);

	}			// main end
}				// class end
