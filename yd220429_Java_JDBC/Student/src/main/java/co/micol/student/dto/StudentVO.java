package co.micol.student.dto;

// DTO
import java.sql.Date;

import lombok.Data;

@Data // Getter Setter 등등 수동 생성 안 하고 lombok라이브러리 이용


public class StudentVO {
	private String studentID; // 칼럼명과 일치하게
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;

	@Override
	public String toString() {
		System.out.print(studentID + " : ");
		System.out.print(name + " : ");
		System.out.print(birthday + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		return null;
	}

}
