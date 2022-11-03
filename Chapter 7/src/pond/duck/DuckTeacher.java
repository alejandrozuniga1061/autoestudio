package pond.duck;

public class DuckTeacher {
	public String name = "helpful"; // public acces
	
	public final int pro;

	public void swim() { // public access
		System.out.println("swim");
	}

	public DuckTeacher() {
		this("hola");
	}

	public DuckTeacher(String name) {
		this.name = name;
		this.pro = 1;
	}

	public static void main(String[] args) {
		DuckTeacher d = new DuckTeacher("");
		System.out.println(d.pro);
	}
}
