package pond.goose;

import pond.duck.DuckTeacher;

public class LostDuckling {

	public void swim() {
		DuckTeacher teacher = new DuckTeacher();
		teacher.swim(); // allowed
		System.out.println("Thanks" + teacher.name); // allowed
	}
	

}
