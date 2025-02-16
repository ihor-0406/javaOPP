package sampleTwo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter extends Thread {
 
	private File destFile;
	private byte[] buffer;
	private boolean hasData = false;
	private boolean done = false;
	
	
	public FileWriter(File destFile) {
		super();
		this.destFile = destFile;
	}

	public synchronized void writeData(byte[] data, int length) {
		for(; hasData;) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		buffer = new byte[length];
		System.arraycopy(data, 0, buffer, 0, length);
		hasData = true;
		notify();
	}
	
	public synchronized void setDone() {
		done = true;
		notify();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (FileOutputStream fos = new FileOutputStream(destFile)){
			for(; !done || hasData;) {
				synchronized (this) {
					for(; !hasData && !done;) {
						wait();
					}
					if(hasData) {
						fos.write(buffer);
						hasData = false;
						notify();
					}
				}
			}
			System.out.println("Copy finished");
		} catch (IOException | InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
