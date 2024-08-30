package co.micol.prj.fileCopy;

public class App {
	public static void main(String[] args) {
		
//		ReadFilecp rd = new ReadFilecp();
//		rd.read();

		// NPE 예외 발생
		WriteFilecp cp = new WriteFilecp();
		cp.copy();
		
//		Copyfile cp = new Copyfile();
//		cp.copy();
		
	}
}

