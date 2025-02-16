package sampleTwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader extends Thread {

	private File sourceFile;
	private byte[] buffer;
	private FileWriter writerThread;
	
	public FileReader(File sourceFile, byte[] buffer, FileWriter writerThread) {
		super();
		this.sourceFile = sourceFile;
		this.buffer = buffer;
		this.writerThread = writerThread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (FileInputStream fis = new FileInputStream(sourceFile)){
			int bytes;
			for(; (bytes = fis.read(buffer)) != 1;) {
				writerThread.writeData(buffer, bytes);
			}
			writerThread.setDone();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
