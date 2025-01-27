package sample;

import java.util.Arrays;

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
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : studens) {
			if(student != null && student.getLastName().equals(lastName)) {
				return student;
			}
		}
		throw new StudentNotFoundException("Студент "+ lastName +" не найден.");
	}
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if(studens[i] != null && studens[i].getId() == id) {
				studens[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Group [groupName= " + groupName + ", studens= " + Arrays.toString(studens) + "]";
	}

	
	
}
