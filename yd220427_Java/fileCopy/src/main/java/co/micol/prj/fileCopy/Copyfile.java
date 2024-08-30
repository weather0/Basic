package co.micol.prj.fileCopy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Copyfile {
	public void copy() {
		try {
			Reader reader = new FileReader("C:/Temp/filecp.txt");
			Writer writer = new FileWriter("C:/Temp/filecp2.txt");
			
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				System.out.print((char) data);
				writer.write(data);
			}
			reader.close();
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
