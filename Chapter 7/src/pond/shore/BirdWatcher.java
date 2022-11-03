package pond.shore;

import pond.goose.Goose;

public class BirdWatcher {
	public void watchBird() {
		Goose bird = new Goose();
		bird.floatInWater(); // calling protected member
		System.out.println(bird.text); // accessing protected member
	}

}
