package part1;

public class Moonweight {

	public static void main(String[] args) {

		double earth_weight = 68;
		String unit = "kg";
		double moon_weight = 0;
		double earth_gravity = 1;
		double moon_gravity = 0.17;

		moon_weight = earth_weight*(moon_gravity/earth_gravity);
		System.out.print(moon_weight);
		System.out.println(unit);
	}

}
