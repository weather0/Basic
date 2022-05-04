package com.yedam.movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yedam.app.common.PropertiesPair;
import com.yedam.movie.vo.BoxofficeResult;
import com.yedam.movie.vo.MovieInfo;

public class MovieService {
	private static final String key = "af560abaeee8e4fe304944042b8a292d"; // 개인발급키
	// 일별 박스 오피스
	public static List<MovieInfo> getDailyBoxofficeResult() {
		String serviceURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";
		// GET방식url구성: 서비스url뒤에?붙이고 뒤에 파라미터 입력
		
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("key", key));
		params.add(new PropertiesPair("targetDt", "20220429"));
		
		// Input스트림 값 무지성으로 받으면 스트링 객체가 무한히 생성되어 과부하 발생
		// └스트링빌더는 내부 메모리가 따로 있어서 append로 붙이면 객체가 하나만 생성돼서 진행 가능 → 과부하 방지
		StringBuilder sb = new StringBuilder();

		// 서버와 연결 & 해제
		try {
			String paramURL = PropertiesPair.getQuery(params);
			String requestURL = serviceURL + paramURL;

			// 서버 호출
			URL url = new URL(requestURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// 서버 응답
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// BufferedReader: 속도향상목적 / getInputStream: 서버출발지
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsonResult = sb.toString();
//		System.out.println(jsonResult); Gson으로 파싱 전 일단 제대로 뜨는지 확인
		
		// 파싱: Gson 라이브러리 활용 방법
		BoxofficeResult result = new Gson().fromJson(jsonResult, BoxofficeResult.class); 

		
//		BoxofficeInfo info = result.getBoxofficeResult();
//		List<MovieInfo> list = info.getDailyBoxOfficeList();
		// 위 두줄을 한줄로 축약한 꼴↓
		return result.getBoxOfficeResult().getDailyBoxOfficeList();
	}

}
