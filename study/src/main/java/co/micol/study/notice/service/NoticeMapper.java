package co.micol.study.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.study.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("key") String val); 
	// Mapper인터페이스에서는 매개변수2개이상일때 @Param필수 (일반적인 서비스IF와의 차이)
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int id); // 조회수 증가
}
