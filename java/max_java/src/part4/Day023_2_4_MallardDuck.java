package part4;

public class Day023_2_4_MallardDuck extends Day023_2_0_Duck {
	
	public Day023_2_4_MallardDuck() {
		FB = new Day023_2_2_FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("duck~duck");
	}

}
