import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Recognizer {
	public static String execute(File file) {
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\desq\\files\\Tess4j"); 
		tesseract.setLanguage("por");
		String result = null;
		try {
		 result = tesseract.doOCR(file);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
