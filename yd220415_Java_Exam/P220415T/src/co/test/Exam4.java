package co.test;

//클래스의 생성과 필드, 메소드, 생성자.
public class Exam4 {
	// 친구의 이름, 생일, 연락처(중복값이 없는 키의 역할)
	String name;
	String birth;
	String call;
	
	
	
	public Exam4(String name, String birth, String call) {
		super();
		this.name = name;
		this.birth = birth;
		this.call = call;
	}

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getCall() {
		return call;
	}


	public void setCall(String call) {
		this.call = call;
	}
	
	
	
	
}
