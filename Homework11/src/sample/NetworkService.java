package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkService {

	public static String getStringFromURL(String spec, String code) throws IOException, URISyntaxException {
	    URI uri = new URI(spec);
	    URL url = uri.toURL();
	    URLConnection connection = url.openConnection();
	    StringBuilder sb = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
	      for (;;) {
	        String textLine = br.readLine();
	        if (textLine == null) {
	          break;
	        }
	        sb.append(textLine).append(System.lineSeparator());
	      }
	      return sb.toString();
	    }
	  }

}