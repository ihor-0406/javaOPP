package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LetterCounter {

	private Map<Character, Integer> frequency = new HashMap<>();
	private String filePath;
	
	public LetterCounter() {
		super();
	}

	public LetterCounter(String filePath) {
		super();
		this.filePath = filePath;
		createFileNotExists();
	}

	public void analyzeText() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(filePath))).toLowerCase();
			for(char c : content.toCharArray()) {
			if(Character.isLetter(c)) {
				frequency.put(c, frequency.getOrDefault(c, 0) + 1);
			}
		 }
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void printFrequency() {
		List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequency.entrySet());
		
		Collections.sort(sortedList, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		for(Map.Entry<Character, Integer> entry : sortedList) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public void createFileNotExists() {
		Path path = Paths.get(filePath);
		if(!Files.exists(path)) {
			try {
				Files.write(path, "Hello! My name is Ihor. Im 27 years old.I`m studying to be a FullStack developer.".getBytes());
				System.out.println("Файл создан:" +filePath);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
