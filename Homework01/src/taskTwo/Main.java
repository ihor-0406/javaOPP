package taskTwo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle triangle1 = new Triangle(4.5, 5, 4.5);
		Triangle triangle2 = new Triangle(11, 15, 7.5);
		
		System.out.println(triangle1);
		System.out.println("Площадь:"+ triangle1.calkulateArea());
		
		System.out.println(triangle2);
		System.out.println("Площадь:"+ triangle2.calkulateArea());
	}

}
