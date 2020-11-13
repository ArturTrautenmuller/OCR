import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Converter {
	public static void convertAndDownload(String resultPath,File[] files,String folderName) {
		for(File file : files) {
			if(file.isFile()) {
				System.out.println("File:"+file.getName());
				String result = Recognizer.execute(file);
				String fileName = file.getName().replaceFirst("[.][^.]+$", "");
				File output = new File(resultPath+"/"+folderName+"---"+fileName+".txt");
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(output));
					writer.write(result);
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(file.isDirectory()) {
				convertAndDownload(resultPath,file.listFiles(),folderName+"---"+file.getName());
			}
		}
	}
}
