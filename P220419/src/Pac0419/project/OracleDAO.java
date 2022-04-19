package Pac0419.project;

public class OracleDAO implements DAO{

	@Override
	public void insert() {
		System.out.println("Oracle입력처리");
	}

	@Override
	public void update() {
		System.out.println("Oracle수정처리");
	}

	@Override
	public void delete() {
		System.out.println("Oracle삭제처리");
	}

	@Override
	public void list() {
		System.out.println("Oracle리스트처리");
	}

}
