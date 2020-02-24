package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class fileRunner {

	public static void main(String[] args) throws IOException {
		File file = new File("/home/");
		System.out.println(file.getAbsolutePath());
		
		// final File folder = new File("/home/you/Desktop");
		//fileRunner fr = new fileRunner();
		//fr.listFilesForFolder(file);
		
		try (Stream<Path> paths = Files.walk(Paths.get(file.getAbsolutePath()))) {
			List<String> lstStr = new ArrayList<>();
			
		    paths
		        .filter(Files::isRegularFile)
		        .forEach((pth)->{
		        	if(pth.toString().contains(".html")) {
		        		System.out.println(pth);
		        	}
		        });
		} 
		
	}
	
	


public void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            System.out.println(fileEntry.getName());
        }
    }
}
	
}
