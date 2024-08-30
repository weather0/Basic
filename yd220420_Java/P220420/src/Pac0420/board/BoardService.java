package Pac0420.board;

public interface BoardService {
	
	public int ADD = 1;
	public int MOD = 2;
	public int DEL = 3;
	public int SEARCH = 4;
	public int LIST = 5;
	public int EXIT = 6;
	
	
	
	public void addBoard();
	public void modBoard();
	public void remBoard();
	public void findBoard();
	public void listBoard();
	
	
	

}
