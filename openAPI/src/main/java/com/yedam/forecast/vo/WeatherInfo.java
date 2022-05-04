package com.yedam.forecast.vo;

import lombok.Data;

@Data
public class WeatherInfo {
	
	private long announceTime; //발표시간! (!는 필수)
	private long numEf; //발효번호(발표시간기준)
	private String regId; //예보구역코드!
	private long rnSt; //강수확률
	private long rnYn; //강수형태!
	private String ta; //예상기온(℃)
	private String wf; //날씨!
	private String wfCd; //날씨코드(하늘상태)!
	private String wsIt; //풍속 강도코드!

}
