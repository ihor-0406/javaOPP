package sample;

import java.util.Scanner;

public class StudentCharacteristics {
	public static Student createStudentInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Пожайлуста напишите ИМЯ студента:");
		String name = sc.nextLine();
		
		System.out.println("Пожайлуста напишите ФАМИЛИЮ студента:");
		String lastname = sc.nextLine();
		
		System.out.println("Пожайлуста напишите ПОЛ студента (MALE/FEMALE):");
		Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());
		
		System.out.println("Пожайлуста напишите номер зачетки студента :");
		int id = sc.nextInt();
		
		System.out.println("Пожайлуста напишите группу студента :");
		sc.nextLine();
		String groupName = sc.nextLine();
		
		return new Student(name, lastname, gender, id, groupName);
	}
	

	
}
