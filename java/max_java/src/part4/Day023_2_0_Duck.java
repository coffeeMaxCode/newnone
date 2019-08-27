package part4;

public abstract class Day023_2_0_Duck {
	int leg;
	Day023_2_1_FlyBehavior FB = null;
	public Day023_2_0_Duck() {
		
	}
	
	public void prefly() {
		FB.fly();
	}
	
	public abstract void display();
	
	public void swimming() {
		System.out.println("Can swim");
	}

}
