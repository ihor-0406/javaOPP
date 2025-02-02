package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperationService  {
	public static long fileCopy(File fileIn, File fileOut) throws IOException {
		try(InputStream is = new FileInputStream(fileIn);
			OutputStream os = new FileOutputStream(fileOut)){
			return is.transferTo(os);
		}
	}

	public static long filesCopyByExtension(File folderIn, File folderOut, String extension) throws IOException {
		
		File[] files = folderIn.listFiles();
		long count = 0;
		if(files == null) {
			return count;
		}
		for(int i = 0; i < files.length; i++) {
			if(files[i].isFile() && files[i].getName().endsWith(extension)) {
				File fileOut = new File(folderOut, files[i].getName());
				fileCopy(files[i], fileOut);
				
				count++;
			}
		}
		return count;
	}
}

