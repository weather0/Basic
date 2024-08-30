package co.micol.prj.fileCopy;

import java.io.FileWriter;
import java.io.Writer;

public class WriteFilecp {
	public void copy() {
		ReadFilecp rd = new ReadFilecp();
		try {
			Writer writer = new FileWriter("C:/Temp/filecp2.txt");
			
			
			writer.write((String)rd.read()); 
			
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
