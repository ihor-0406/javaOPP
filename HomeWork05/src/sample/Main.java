package sample;

import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    File folderIn = new File("C:\\Users\\IHOR\\Documents");
    File folderOut = new File("File01");
    String extension = ".txt";
    folderOut.mkdir();
    
    try {
      long copiedFile = FileOperationService.filesCopyByExtension(folderIn, folderOut, extension);
      System.out.println("Файлы скопированы : "+ copiedFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}