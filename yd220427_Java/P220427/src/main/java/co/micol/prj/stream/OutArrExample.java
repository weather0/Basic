package co.micol.prj.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutArrExample {
	public void run() {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test2.txt");
			
			byte[] array = { 'A', 'B', 'C' }; 
			// 기본따옴표는 문자. 쌍따옴표는 문자열(기본: 문자+null(최소2바이트))
			os.write(array);
			os.flush();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
