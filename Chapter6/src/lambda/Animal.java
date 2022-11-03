package lambda;

public class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String speciesName, 
			boolean hopper,
			boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String toString() {
		return species;
	}

	@Override
	public boolean equals(Object obj) {
		Animal a = (Animal) obj;
		System.out.println("Entro " + a.canHop() + a.canSwim());
		return a.species.equals(this.species);
	}
	
	
}
