package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] studens = new Student[10];
	
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group(String groupName, Student[] studens) {
		super();
		this.groupName = groupName;
		this.studens = studens;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudens() {
		return studens;
	}

	public void setStudens(Student[] studens) {
		this.studens = studens;
	}
	public void addStudent(Student student) throws GroupOverflowException{
		for(int i = 0; i < studens.length; i++) {
			if(studens[i] == null) {
				studens[i]= student;
				return;
			}
		}
		throw new GroupOverflowException("Группа уже переполнена");
	}
	
//	Поиск студента
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : studens) {
			if(student != null && student.getLastName().equals(lastName)) {
				return student;
			}
		}
		throw new StudentNotFoundException("Студент "+ lastName +" не найден.");
	}
	
//	Удаление по ID:
	
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if(studens[i] != null && studens[i].getId() == id) {
				studens[i] = null;
				return true;
			}
		}
		return false;
	}
	
//	Сортировка студентов:
	
	public void sortStudentsByLastName() {
		Arrays.sort(studens, Comparator.nullsLast(new StudentLastNameComprator()));
	}
	
//	Добавление группы в CSV:
	
	public String toStringRepresentation() {
		CSVStringConverter converter = new CSVStringConverter();
		String result = groupName + "\n";
		for(Student student : studens) {
			if(student != null) {
				result += converter.toStringRepresentation(student);
			}
		}
		return result;
	}
	
//	Вывод группы из CSV:
	
	public void fromStringRepresentation(String csv) {
		String[] lines = csv.split("\n");
		this.groupName= lines [0];
		CSVStringConverter converter1 = new CSVStringConverter();
		for(int i = 1; i < lines.length; i++) {
			if(!lines[i].isBlank()) {
				Student student = converter1.fromStringRepresentation(lines[i]);
				try {
					addStudent(student);
				} catch (GroupOverflowException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Group [groupName= " + groupName +" | "+ ": studens= " + Arrays.toString(studens) + "]";
	}
	
}
