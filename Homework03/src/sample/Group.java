package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Group {
	private String groupName;
//	private Student[] studens = new Student[10];
	private List<Student> students = new ArrayList<Student>();
	
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	
    public Group(String groupName, List<Student> student) {
		super();
		this.groupName = groupName;
		this.students = student;
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

	public List<Student> getStudent() {
		return students;
	}


	public void setStudent(List<Student> student) {
		this.students = student;
	}

	public void addStudent(Student student) throws GroupOverflowException{
		if(students.size() >= 10) {
			throw new GroupOverflowException("Группа уже переполнена");
		}
		students.add(student);
	}
	
//	Поиск студента
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : students) {
			if(student.getLastName().equals(lastName)) {
				return student;
			}
		}
		throw new StudentNotFoundException("Студент "+ lastName +" не найден.");
	}
	
//	Удаление по ID:
	
	public boolean removeStudentByID(int id) {
		
		return students.removeIf(student -> student.getId() == id);
	}
	
//	Сортировка студентов:
	
	public void sortStudentsByLastName() {
		students.sort(new StudentLastNameComprator());
	}
	
//	Добавление группы в CSV:
	
	public String toStringRepresentation() {
		CSVStringConverter converter = new CSVStringConverter();
		StringBuilder result = new StringBuilder(groupName + "\n");
		for(Student student : students) {
			result.append(converter.toStringRepresentation(student)).append("\n");
		}
		return result.toString();
	}
	
//	Вывод группы из CSV:
	
	public void fromStringRepresentation(String csv) {
		String[] lines = csv.split("\n");
		this.groupName= lines [0];
		CSVStringConverter converter1 = new CSVStringConverter();
		students.clear();
		for( int i = 1; i < lines.length; i ++) {
			if(!lines[i].isBlank()) {
				Student student = converter1.fromStringRepresentation(lines[i]);
				students.add(student);
			}
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}


	public boolean equivalentStudents() {
		for(int i = 0; i < students.size(); i++) {
			for(int g = i + 1; g < students.size(); g++) {
				if(students.get(i).equals(students.get(g))) {
					System.out.println("У Вас в группе присутсвуют одинаковые студуденты!");
					return true;
				}
			}
		}
		System.out.println("Эквивалентных студентов нету!");
		return false;
	}


	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + students + "]";
	}

	
	
}
