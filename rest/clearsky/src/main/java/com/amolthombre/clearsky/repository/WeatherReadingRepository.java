package com.amolthombre.clearsky.repository;

import java.util.List;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;

public interface WeatherReadingRepository {
	public WeatherReading create(WeatherReading weatherReading);
	
	public List<String> listOfCities();
	
	public WeatherReading weatherForGivenCity(String city);
	
	public List<AverageWeather> getHourlyAverageWeatherForCity(String city);
	
	public List<AverageWeather> getDailyAverageWeatherForCity(String city);
}
