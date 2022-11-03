package pond.duck;

public class FatherDuck {
	private String noise = "quack";

	private void quack() {
		System.out.println(noise); // private access ok

	}

	private void makeNoise() {
		quack(); // private access okR
	}
}
