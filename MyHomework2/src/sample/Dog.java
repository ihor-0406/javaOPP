package sample;

public class Dog extends Animal {
    private String name;

    public Dog(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Dog " + name + " is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog " + name + " is sleeping...");
    }

    public String getVoice() {
        return "Woof!";
    }

    @Override
	public String toString() {
		return "Dog [name=" + name +", "+ super.toString() + "]";
	}
}
