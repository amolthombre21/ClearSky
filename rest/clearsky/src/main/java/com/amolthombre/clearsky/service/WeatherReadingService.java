package com.amolthombre.clearsky.service;

import java.util.List;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;

public interface WeatherReadingService {
	public WeatherReading create(WeatherReading weatherReading);
	
	public List<String> listOfCities();
	
	public WeatherReading weatherForGivenCity(String city);
	
	public WeatherReading getPropertyForCity(String city, String property);
	
	public int getWeatherPropertyForCity(String city, String property) throws Exception;
	
	public List<AverageWeather> getAverageWeatherForCity(String city, String grain);
}
