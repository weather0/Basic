package co.micol.prj.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputExample {
	public void run() {
		try {
			OutputStream outputStream = new FileOutputStream("C:\\Temp\\test.txt");
			byte a = 40;
			byte b = 41;
			byte c = 42;
			outputStream.write(a);
			outputStream.write(b);
			outputStream.write(c);
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
