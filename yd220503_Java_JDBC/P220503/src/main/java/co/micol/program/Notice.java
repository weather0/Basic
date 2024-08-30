package co.micol.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.serviceimpl.NoticeServiceImpl;

public class Notice {
	Scanner scn = new Scanner(System.in);
	NoticeService notice = new NoticeServiceImpl();

	// 전체목록조회
	public void noticeAll() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = notice.noticeSelectList();

		System.out.println("===================== 전체공지목록 ========================");
		for (NoticeVO vo : list) {
			vo.toString();
		}
		System.out.println("========================================================");

	}

	// 한 명 조회
	public void noticeOne() {
		System.out.println("===================== 공지사항조회 ========================");
		System.out.print("조회를 원하는 글 번호를 입력>>");
		NoticeVO vo = new NoticeVO();
		int noticeNo = Integer.parseInt(scn.nextLine());
		vo.setId(noticeNo);
		vo = notice.noticeSelect(vo);
		vo.toString();
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println(vo.getSubject());

	}

	// 새 글 입력
	public void noticeWrite() {
		NoticeVO vo = new NoticeVO();
		System.out.println("===================== 공지사항등록 ========================");
		System.out.print("작성자 입력>>");
		String write = scn.nextLine();
		vo.setWriter(write);
		System.out.println("글 제목 입력>>");
		vo.setTitle(write);
		System.out.println("글 내용 입력>>");
		vo.setSubject(write);
		int n = notice.noticeInsert(vo);
		if (n != 0) {
			System.out.println("입력 완료");
		} else {
			System.out.println("입력 실패");
		}

	}


}
