package com.company.app.common;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum = 1;
	private int amount = 10;
	private String type;
	private String keyword;
}
