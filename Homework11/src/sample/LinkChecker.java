package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LinkChecker {

	public static String checkURL(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(2000);
			connection.setReadTimeout(2000);
			connection.connect();
			int statusCode = connection.getResponseCode();
			return (statusCode == 200) ? "Доступен ( " + statusCode + " );" : "Недоступен ( " + statusCode + " );";
		} catch (IOException e) {
			return "Ошибка";
		}
	}
	
	public static void checkLinksAndSave ( String inputFile, String outputFile) {
		
		List<String> links = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
			for(String line; (line = br.readLine()) != null;) {
				links.add(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))){
			for(int i = 0; i < links.size(); i++) {
				String status = checkURL(links.get(i));
				writer.println(links.get(i) + " -> " + status);
			}
		} catch (IOException e) {
			System.out.println("Ошибка записи :" + e.getMessage());
		}
	}
}
