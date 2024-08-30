package ac.yedam.mvc.reply;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class ReplyVO {
	private String rno;
	private String bno;
	private String reply;
	// @JsonAlias(value = "writer") // 필드 바꾸고 싶을 때
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyDate;
	@JsonIgnore
	private Date updateDate;
}
