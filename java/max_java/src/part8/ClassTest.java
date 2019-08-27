package part8;

import part1.car;
import part1.Sonata;

public class ClassTest {

	public static void main(String[] args) {
		car mycar = new Sonata();
		if(mycar instanceof Sonata) {
			Class c = mycar.getClass();
			c = Sonata.class;
			if(mycar instanceof Sonata) {
				
			}
		}
		Sonata yourcar = new Sonata();
		try {
		Class c1 = Class.forName("part1.Sonata");
		Sonata himCar =(Sonata)c1.newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
