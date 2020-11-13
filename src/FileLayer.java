import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLayer {
	public static File[] pickFiles(String sourcePath) {
		File folder = new File(sourcePath);
		return folder.listFiles();
		}
	
	
}
