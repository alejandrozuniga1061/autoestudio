package otro;

import java.util.ArrayList;
import java.util.List;

public class OverrideMethod {
	public static void main(String[] args) {
		List<Y> hola = new ArrayList<>();
		algo(hola);
	}

	private static void algo(List<? extends X> a) {

	}
}

class LongTailAnimal {
	protected void chew(List<Object> input) {
	}
}

class Anteater extends LongTailAnimal {
	protected void chew(ArrayList<Double> input) {
	} // DOES NOT COMPILE
}

interface W {
	
}

interface X extends W {

}

class Y implements X {

}