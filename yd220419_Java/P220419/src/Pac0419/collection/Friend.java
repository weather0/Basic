package Pac0419.collection;

// 친구의 주소록 : 이름, 연락처
// 학교친구 : 학교이름, 전공과목
// 회사친구 : 회사이름, 부서
public class Friend {

	public String name;
	public String phone;
//	public String gender; 이렇게 String타입으로 해놓으면 "남, 남자, M, 여, 여자, W" 혼동
	public Gender gender; // enum열거형타입

	public Friend(String name, String phone, Gender gender) {
		super();
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}

//	public Friend(String name, String phone) {
//		super();
//		this.name = name;
//		this.phone = phone;
//	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String showData() {
		return name + "     " + phone;

	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", gender=" + gender + "]";
	}

}
