package sample;

public class Cat extends Animal {
	private String name;

	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}
	

	public Cat(String ration, String color, int weight) {
		super(ration, color, weight);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void eat() {
		System.out.println("Cat " + name + " is eating...");
	}
	
	@Override
	public void sleep() {
		System.out.println("Cat " + name + " is sleeping...");
	}
	public String getVoice() {
		return " Meow";
	}
	@Override
	public String toString() {
		return "Cat [name=" + name+ ", " + super.toString() + "]";
	}
}
