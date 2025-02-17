package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private Map<String, String> dictionary = new HashMap <>();
	private String filePath;
	
	public Dictionary(String filePath) {
		super();
		this.filePath = filePath;
	}

	public Dictionary() {
		super();
	}
	
	public void addWord(String eng, String ukr) {
		dictionary.put(eng, ukr);
	}
	public String translate(String word) {
		return dictionary.getOrDefault(word, "Не найдено");
	}
	public void savaDictionary() {
		try(BufferedWriter wr= new BufferedWriter(new FileWriter(filePath))) {
			for(Map.Entry<String, String> entry : dictionary.entrySet()) {
				wr.write(entry.getKey() + " = " + entry.getValue());
				wr.newLine();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void loadDictionary() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			for(String line; (line = reader.readLine()) != null;) {
				String[] parts = line.split(" = ");
				if(parts.length == 2) {
					dictionary.put(parts[0], parts[1]);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void createFileIfNotExists() {
		try {
			File file = new File(filePath);
			if(file.createNewFile()) {
				System.out.println("Файл создан " + filePath);
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void showAllWords() {
		if(dictionary.isEmpty()) {
			System.out.println("Словарь пуст!");
		}else {
			for(Map.Entry<String, String> entry : dictionary.entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
		
	}
}