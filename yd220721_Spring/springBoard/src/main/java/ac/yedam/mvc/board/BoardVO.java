package ac.yedam.mvc.board;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private String bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;

}
