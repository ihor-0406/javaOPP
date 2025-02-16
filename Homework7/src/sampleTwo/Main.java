package sampleTwo;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File sourceFile = new File("C:\\Users\\IHOR\\Videos\\ArmA 3");
		File desFile = new File("AAa");
		desFile.mkdir();
		
		FileWriter writer = new FileWriter(desFile);
		byte[] buffer = new byte[300];
		FileReader reader = new FileReader(sourceFile, buffer, writer);
		
		writer.start();
		reader.start();
	}

}
