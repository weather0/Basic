package com.yedam.forecast.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.yedam.app.common.PropertiesPair;
import com.yedam.forecast.vo.WeatherInfo;

public class WeatherService {

	public static List<WeatherInfo> getWeatherForecast() {
		String key = "W/kD7w+TSJtH1v5JowoYUG+xOBmpCDkp4ZFHMLj1AvBvL+AOwPj1abblDi87Yl3cuizWe0bqDC1pryLGAq9xWA==";

		String serviceURL = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst?";

		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("ServiceKey", key));
		params.add(new PropertiesPair("pageNo", "1"));
		params.add(new PropertiesPair("numOfRows", "10"));
		params.add(new PropertiesPair("dataType", "JSON"));
		params.add(new PropertiesPair("regId", "11A00101"));

		StringBuilder sb = new StringBuilder();

		String paramURL;
		try {
			paramURL = PropertiesPair.getQuery(params);
			String requestURL = serviceURL + paramURL;

			// 서버 호출
			URL url = new URL(requestURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/json"); // 지금은 안써도 무방하나, 추후 파일이나 이미지등 전손할때는 타입지정해줘야함

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
//		System.out.println(jsonResult);
		return getWeatherData(jsonResult);
	}

	// 파싱: JSON.simple 라이브러리 활용 방법
	// Gson보다 장점: 하나하나 요소 만들기 가능
	private static List<WeatherInfo> getWeatherData(String jsonData) {
		List<WeatherInfo> list = new ArrayList<WeatherInfo>();

		try {
			JSONParser parser = new JSONParser();
			JSONObject forecastData = (JSONObject) parser.parse(jsonData);
			JSONObject response = (JSONObject) forecastData.get("response"); // 우변 "response": 기상청 샘플코드에서 객체 값
			JSONObject body = (JSONObject) response.get("body");
			JSONObject items = (JSONObject) body.get("items");
			JSONArray item = (JSONArray) items.get("item");

			for (int i = 0; i < item.size(); i++) {
				JSONObject data = (JSONObject) item.get(i);
				WeatherInfo info = new WeatherInfo();

				
				// 삼항연산자: null이에요? true면 0, 아니면 ~
				// └기상요소중 필수 아닌 옵션(발효번호,강수확률,예상기온)은 null일 수도 있으니깐
				
				// 발표시간! (!는 필수)
				info.setAnnounceTime((long) data.get("announceTime"));
				// 발효번호(발표시간기준)
				info.setNumEf((data.get("numEf") == null) ? 0 : (long) data.get("numEf"));
				// 예보구역코드!
				info.setRegId((String) data.get("regId"));
				// 강수확률
				info.setRnSt((data.get("rnSt") == null) ? 0 : (long) data.get("rnSt"));
				// 강수형태!
				info.setRnYn((long) data.get("rnYn"));
				// 예상기온(℃)
				info.setTa((data.get("ta") == null) ? "" : (String) data.get("ta"));
				// 날씨!
				info.setWf((String) data.get("wf"));
				// 날씨코드(하늘상태)!
				info.setWfCd((String) data.get("wfCd"));
				// 풍속 강도코드!
				info.setWsIt((String) data.get("wsIt"));

				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
