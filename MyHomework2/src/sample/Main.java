package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1= new Cat("Whiskas" , "Black", 4, "Leska");
		Dog dog1 = new Dog("Meat" , "Red", 8, "Molly");
		
		Veterinarian vet = new Veterinarian("Dr.Alban");
		
		System.out.println(cat1);
		cat1.eat();
		cat1.sleep();
		System.out.println("Cat void:" + cat1.getVoice());
		
		System.out.println(dog1);
		dog1.eat();
		dog1.sleep();
		System.out.println("Dog void: " +dog1.getVoice());
		
		vet.treatment(cat1);
		vet.treatment(dog1);
	}

}
