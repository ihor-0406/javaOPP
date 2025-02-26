package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	 public static void main(String[] args) {
		    String spec = "https://dou.ua/";
		    String statusFile = "status.txt";

		    try {
		      String html = NetworkService.getStringFromURL(spec, "UTF-8");
		      saveToFile(new File("index.html"), html);
		      System.out.println("HTML сохранен....");
		      
		      List<String> links = extractLinks("index.html", spec);
		      saveToFile(new File("links.txt"), java.lang.String.join("\n", links));
		      
		      LinkChecker.checkLinksAndSave("links.txt", statusFile);
		      System.out.println("Результаты проверки сохранены :" + statusFile);
		      
		    } catch (IOException | URISyntaxException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

		    System.out.println("Done!");
		  }

		  public static void saveToFile(File file, String text) throws IOException {
		    try (PrintWriter pw = new PrintWriter(file)) {
		      pw.println(text);
		    }
		  }
		  
		  public static List<String> extractLinks(String filePath, String baseUrl){
			    
			    List<String> links = new ArrayList<>();
			    StringBuilder html = new StringBuilder();
			    
			    try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
					for(String line; (line = br.readLine()) !=null;){
						html.append(line).append("\n");
					}
				} catch (IOException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					return links;
				}
			    
			    String htmlText = html.toString();
			    htmlText = htmlText.replace("'", "\"").toLowerCase();
			    
			    for(int i = 0; (i = html.indexOf("<a href=\"", i)) != -1; i++) {
			      i += 9;
			      int endI = html.indexOf("\"", i);
			      if(endI != -1) {
			        String link = html.substring(i, endI);
			        if(!link.startsWith("http")) {
			        	if(link.startsWith("//")) {
			        		 link = baseUrl + link;
			        	}else if(link.startsWith("/")){
			        		link = baseUrl + link;
			        	}else {
			        		link = baseUrl + "/" + link;
			        	}
			        }
			        links.add(link);
			        i = endI;
			      }
			    }
			    System.out.println("Найдено " + links.size() + " ссылок");
			    return links;
			  }
}
