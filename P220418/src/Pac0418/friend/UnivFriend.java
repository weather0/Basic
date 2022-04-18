package Pac0418.friend;

public class UnivFriend extends Friend {

	private String univ;
	private String major;

	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); // 부모생성자는 맨위에 super()로 적음
		this.univ = univ;
		this.major = major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "UnivFriend [name=" + this.getName() + ", phone=" + super.getPhone() + ", univ=" + univ + ", major="
				+ major + "]";
	} // phone에 대해 자식에서 재정의(오버라이딩)을 안했기 떄문에 this(자기자신)나 super(부모) 둘다 결과는 동일

	public String showData() {
		return super.getName() + "     " + super.getPhone() + "     " + univ + "     " + major + "     ";

	}

}
