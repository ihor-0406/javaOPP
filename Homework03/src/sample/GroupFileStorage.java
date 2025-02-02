package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GroupFileStorage {

	public void saveGroupToCSV(Group group) throws IOException {
		
		String fileName = group.getGroupName().replace(" ", "_") + ".csv";
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			
			writer.write(group.toStringRepresentation());
		}
		System.out.println("Группа сохранена в " + fileName);
	}
	
	public  Group loadGroupFromCSV(File file)  throws IOException {
		
		Group group = new Group();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			String[] lines = reader.lines().toArray(String[]::new);
			for(int i = 0; i < lines.length; i++) {
				if(i==0) {
					group.setGroupName(lines[i]);
				}else {
					CSVStringConverter converter = new CSVStringConverter();
					try {
						 Student student = converter.fromStringRepresentation(lines[i]); 
						 group.addStudent(student);
					} catch (GroupOverflowException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
						break;
					}
				}
			}
		}
		System.out.println("Группа загружена : " + file.getName());
		return group;
	}
	

	public File findFileByGroupName(String groupName, File workFolder) {
		
		if(!workFolder.exists() || !workFolder.isDirectory()) {
			System.out.println("Такой папки нету");
			return null;
		}
		String targetFileName = groupName.replace(" ", "_") + ".csv";
		File[] files = workFolder.listFiles();
		
		if(files != null) {
			for(File file : files) {
				if(file.isFile() && file.getName().equals(targetFileName)) {
					return file;
				}
			}
		}
		
		System.out.println("Файл : " +targetFileName + " не найден " +workFolder.getAbsolutePath());
		return null;
	}
}
