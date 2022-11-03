package lambda;

import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {
	public static void main(String[] args) {
		// list of animals
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));

		// pass class that does check
		print(animals, new CheckIfHopper());
		print(animals, a -> a.canHop());
	}

	private static void print(List<Animal> animals,
			CheckTrait checker) {
		for (Animal animal : animals)
			if (checker.test(animal))
				System.out.println(animal + " ");

		System.out.println("---------------");
		
		animals.stream()
		.filter( a -> checker.test(a))
		.forEach(System.out::println);
	}

}
