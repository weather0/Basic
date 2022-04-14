package Pac0414;

public class Member {
	// 필드 -> 회원아이디, 이름, 연락처, 나이
	private String id; // private 외부에서 Member클래스에 접근못하게
	private String name;
	private String contact;
	private int age; // 무조건 양수

	
	
	
	
	
	
	
// ─────────────────────────────────────────────────────
	// 생성자
	public Member(String id, String name, String contact, int age) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.age = age;
	}
	
	
	
	
	
// ─────────────────────────────────────────────────────
	// 메서드

	// 우클릭-소스-getters setters
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	

	
	
	
	
	
	
//	void setId(String id) {
//		this.id = id;
//	}
//	
//	
//	void setAge(int page) {
//		if (page < 0) {
//			age = 10;
//		}else {
//			age = page;		
//		}
//	} // 나이에음수 넣으면 10살이 되도록
//	
//	int getAge(){
//		return age;
//	}
	
	
	void showInfo() {
		System.out.printf("회원이름 %4s\n연락처 %13s\n나이 %2d\n", name, contact, age);
	}





	
	
	
	
	
	
	
	
	
	
}
