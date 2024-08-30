package Pac0419.collection;

import java.util.ArrayList;

// 컬렉션 활용
public class FriendServiceList implements FriendService {
	ArrayList<Friend> friends = new ArrayList<Friend>();
//  ArrayList<Friend> friends = new ArrayList<Friend>(); 
//  이렇게 제네릭타입<> 넣으면 밑에서 Friend findFriend 이렇게 Friend 인스턴스, 새변수, 캐스팅 다 필요없고
//  바로 friends.get(i)가지고 풀어가면 됨

	@Override
	public void addFriend(Friend friend) {
		friends.add(friend);
	}

	@Override
	public void modFriend(Friend friend) {
		for (int i = 0; i < friends.size(); i++) {
			Friend findFriend = (Friend) friends.get(i); // get은 형변환해야함
			if (findFriend.getName().equals(friend.getName())) {
				// 위에서 제네릭타입<>쓰면 Friend타입 인스턴스 캐스팅 지우고 
				// if(friends.get(i).getName()~ 이렇게 직접 대입해서 풀어가면 됨
				findFriend.setPhone(friend.getPhone());
				break;
			}
		}
	}

	@Override
	public void remFriend(String name) {
		for (int i = 0; i < friends.size(); i++) {
			Friend findFriend = (Friend) friends.get(i);
			if (findFriend.getName().equals(name)) {
				friends.remove(i);
				break;
			}
		}
	}

	@Override
	public Friend findFriend(String name) {
		for (int i = 0; i < friends.size(); i++) {
			Friend findFriend = (Friend) friends.get(i);
			if (findFriend.getName().equals(name)) {
				return findFriend;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Friend> findGender(Gender gender) {
		ArrayList<Friend> list = new ArrayList<Friend>();
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getGender() == gender) {
				// 열거형타입(enum): 클래스타입 같은 참조타입
				// 기본타입 == 비교연산자
				// 열거형 == 비교연산자로 비교(주소값 사용하기 떄문). equals 안씀
				list.add(friends.get(i));
			}
		}
		return list;
	}

}
