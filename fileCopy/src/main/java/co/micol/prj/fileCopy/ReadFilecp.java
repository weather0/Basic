package co.micol.prj.fileCopy;

import java.io.FileReader;
import java.io.Reader;

public class ReadFilecp {
	public String read() {
		try {
			Reader reader = new FileReader("C:/Temp/filecp.txt");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				System.out.print((char) data);
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;

	}

}
