package sample;

import java.util.Comparator;

public class StudentLastNameComprator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Student stu1= (Student) o1;
		Student stu2= (Student) o2;
		
		String name1 = stu1.getName();
		String name2 = stu2.getName();
		
		if(name1.compareTo(name2) > 0) {
			return 1;
		}if(name1.compareTo(name2) < 0) {
			return -1;
		}
		return 0;
	}
	
}
