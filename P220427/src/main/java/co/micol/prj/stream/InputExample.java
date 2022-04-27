package co.micol.prj.stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputExample {
	public void run() {

		try {
			InputStream in = new FileInputStream("C:/Temp/test2.txt");
			byte[] buffer = new byte[100];
			while (true) {
				int data = in.read(buffer);
				if (data == -1)
					break;
				for (int i = 0; i < data; i++) {
					System.out.println(buffer[i]);
				}
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
