package Pac0419.project;

public class MySqlDAO implements DAO {

	@Override
	public void insert() {
		System.out.println("MySQL입력처리");
	}

	@Override
	public void update() {
		System.out.println("MySQL수정처리");
	}

	@Override
	public void delete() {
		System.out.println("MySQL삭제처리");
	}

	@Override
	public void list() {
		System.out.println("MySQL리스트처리");
	}

}
