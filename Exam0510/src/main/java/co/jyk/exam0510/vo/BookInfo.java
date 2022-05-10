package co.jyk.exam0510.vo;

import lombok.Data;

@Data
public class BookInfo {
	private String bookname;
	private String author;
	private String content;
	private String rent;
	
	
	public String toString() {
		System.out.println("책제목 : "+bookname+", 저자명 : "+author+", 내용 : "+content+", 대여여부 : "+rent);
		
	 return null;
	}

}
