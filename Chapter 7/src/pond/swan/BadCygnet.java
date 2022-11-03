package pond.swan;

import pond.duck.MotherDuck;

public class BadCygnet {
	public final void makeNoise() {
		MotherDuck duck = new MotherDuck();
		duck.quack();
		System.out.println(duck.noise); 
	}
}
