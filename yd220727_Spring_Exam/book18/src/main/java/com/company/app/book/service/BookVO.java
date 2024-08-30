package com.company.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private String bookNo;
	private String bookName;
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	private String rentsum;
	private String rentcnt;
	

}
