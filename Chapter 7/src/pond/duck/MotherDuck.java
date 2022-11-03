package pond.duck;

public class MotherDuck {
	String noise = "quack";

	void quack() {
		System.out.println(noise); // private access ok

	}

	private void makeNoise() {
		quack(); // private access okR
	}
}
