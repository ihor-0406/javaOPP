package sample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Group group = new Group("Java OOP");
			
			Student stu1 = new Student("Igor", "Shevchenko", Gender.MALE, 600, "Java OOP");
			Student stu2 = new Student("Oleg", "Shmatok", Gender.MALE, 610, "Java OOP");
			Student stu3 = new Student("Anna", "Romanovskaya", Gender.FEMALE, 620, "Java OOP");
			Student stu4 = new Student("Ruslan", "Bobkov", Gender.MALE, 630, "Java OOP");
			Student stu5 = new Student("Elizaveta", "Omanska", Gender.FEMALE, 640, "Java OOP");
			Student stu6 = new Student("Artem", "Moshkun", Gender.MALE, 640, "Java OOP");
			Student stu7 = new Student("Artur", "Angliyskiy", Gender.MALE, 650, "Java OOP");
			Student stu8 = new Student("Rostislav", "Moroznichenko", Gender.MALE, 660, "Java OOP");
			Student stu9 = new Student("Marina", "Ermakova", Gender.FEMALE, 670, "Java OOP");
			Student stu10 = new Student("Mariya", "Khomyakova", Gender.FEMALE, 675, "Java OOP");
			
//		    Student stu11 = new Student("Павел", "Лишний", Gender.MALE, 11,"Java OOP");
			
			
			group.addStudent(stu1);
			group.addStudent(stu2);
			group.addStudent(stu3);
			group.addStudent(stu4);
			group.addStudent(stu5);
			group.addStudent(stu6);
			group.addStudent(stu7);
			group.addStudent(stu8);
			group.addStudent(stu9);
			group.addStudent(stu10);
			
//			group.addStudent(stu11);
			
			System.out.println(group.toStringRepresentation() );
			System.out.println(group.equivalentStudents());

			
			System.out.println("*********************");
			
			Student foutStudent = group.searchStudentByLastName("Romanovskaya");
			System.out.println("Найден студент:" +foutStudent);
			
//    		Student foutStudent2 = group.searchStudentByLastName("Лишний");

			System.out.println("*********************");
			
			boolean removed = group.removeStudentByID(00650);
			System.out.println("Удалить :  " + removed);
			
			boolean removed1 = group.removeStudentByID(076150);
			System.out.println("Удалить : " + removed1);
			
			System.out.println("*********************");
			
			System.out.println("Группа после сортировки:");
			group.sortStudentsByLastName();
			System.out.println(group);
			
			System.out.println("***********CSV**********");
			
			System.out.println(group.toStringRepresentation());
			
			Group restoredGroup = new Group();
			restoredGroup.fromStringRepresentation(group.toStringRepresentation());
			
			System.out.println("***********from CSV**********");
			System.out.println(restoredGroup);
			
			
			System.out.println("*********************");
			
			GroupFileStorage storage = new GroupFileStorage();
			
			
			try {
				storage.saveGroupToCSV(group);
				File workFolder = new File(".");
			File groupFile = storage.findFileByGroupName("Java OOP", workFolder);
			
			if(groupFile != null) {
				Group loadedGroup = storage.loadGroupFromCSV(groupFile);
				System.out.println("\nГруппа загружена");
				System.out.println(loadedGroup);
			}
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		
			
			
			
			/*
			 * Возврат студентов на основе считаемых данных с 
			 * клавиатуры и возможность добавления новой группы до 10 человек и выводом их в console.
			 */
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Напишите название группы: ");
			String groupName = sc.nextLine();
			
			Group newGroup = new Group(groupName);
			for(int i=0; i < 10; i++) {
				System.out.println("Хотите добавить студента? (Yes/No)");
				String addStudent = sc.nextLine(); 
				if(!addStudent.equals("Yes")) {
					break;
				}
				Student newStudent = StudentCharacteristics.createStudentInput();
				try {
					newGroup.addStudent(newStudent);
					System.out.println("Студент добавлен");
				} catch (GroupOverflowException e) {
					System.out.println("Группа переполнена");
					break;
					// TODO: handle exception
				}
			}
			System.out.println(newGroup.toStringRepresentation());
			
		}catch (GroupOverflowException | StudentNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
