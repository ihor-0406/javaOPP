package sample;

public class CSVStringConverter implements StringConverter {
	
	public String toStringRepresentation(Student student) {
		return student.getName() +  " , " + student.getLastName() + " , " + student.getGender() + " , " + student.getId() + " , " + student.getGroupName() + " ";
	}
	public Student fromStringRepresentation(String str) {
		String[] parts = str.split(" , ");
		String name = parts [0];
		String lastName = parts [1];
		Gender gender = Gender.valueOf(parts[2]);
		int id = Integer.parseInt(parts [3]);
		String groupName = parts [4];
		
		return new Student(name, lastName, gender, id, groupName);
	}

}
