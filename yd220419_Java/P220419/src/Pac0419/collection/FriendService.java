package Pac0419.collection;

import java.util.ArrayList;

public interface FriendService {
	
	// 상수
	public int ADD = 1;
	public int MOD = 2;
	public int DEL = 3;
	public int SEARCH = 4;
	public int FIND_MEN = 5;
	public int FIND_WOMEN = 6;
	
	
	
	// 추가,수정,삭제,조회
	public void addFriend(Friend friend);
	public void modFriend(Friend friend);
//	public void modFriend(String name, String phone); 
	//이렇게 만들면 다른데서 호출할때도 매개값에 Friend타입으로 받는게 아니라 String,String타입으로 받아야함 
	public void remFriend(String name);
	public Friend findFriend(String name);
	public ArrayList<Friend> findGender(Gender gender);

}
