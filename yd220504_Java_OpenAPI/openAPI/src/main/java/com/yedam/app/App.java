package com.yedam.app;

import java.util.List;

import com.yedam.forecast.service.WeatherService;
import com.yedam.forecast.vo.WeatherInfo;
import com.yedam.movie.vo.MovieInfo;

public class App {

	public static void main(String[] args) {
		
//		List<MovieInfo> list = MovieService.getDailyBoxofficeResult();
//		for(MovieInfo info : list) {
//			System.out.println(info);
//		}
		
		List<WeatherInfo> list = WeatherService.getWeatherForecast();
		for(WeatherInfo info : list) {
			System.out.println(info);
		}
	
		
		
		
		
		
		
		
	}

}
