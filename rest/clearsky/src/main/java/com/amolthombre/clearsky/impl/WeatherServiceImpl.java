package com.amolthombre.clearsky.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;
import com.amolthombre.clearsky.repository.WeatherReadingRepository;
import com.amolthombre.clearsky.service.WeatherReadingService;

@Service
public class WeatherServiceImpl implements WeatherReadingService{
	
	WeatherReadingRepository weatherReadingRepository;
	
	public WeatherServiceImpl(WeatherReadingRepository weatherReadingRepository) {
		this.weatherReadingRepository = weatherReadingRepository;
	}

	@Override
	@Transactional
	public WeatherReading create(WeatherReading weatherReading) {
		return weatherReadingRepository.create(weatherReading);
	}

	@Override
	public List<String> listOfCities() {
		return weatherReadingRepository.listOfCities();
	}

	@Override
	public WeatherReading weatherForGivenCity(String city) {
		return weatherReadingRepository.weatherForGivenCity(city);
	}

	@Override
	public WeatherReading getPropertyForCity(String city, String property) {
		return null;
	}

	@Override
	public int getWeatherPropertyForCity(String city, String property) throws Exception {
		WeatherReading weatherReading =  weatherForGivenCity(city);
		int specificProperty;
		if(property.equals("humidity"))
			specificProperty = weatherReading.getHumidity();
		else if(property.equals("pressure"))
			specificProperty = weatherReading.getPressure();
		else if(property.equals("temperature"))
			specificProperty = weatherReading.getTemperature();
		else
			throw new Exception();
		return specificProperty;
	}

	@Override
	public List<AverageWeather> getAverageWeatherForCity(String city, String grain) {
		if(grain.equals("hourly"))
			return weatherReadingRepository.getHourlyAverageWeatherForCity(city);
		else if(grain.equals("daily"))
			return weatherReadingRepository.getDailyAverageWeatherForCity(city);
		else
			return null;
	}	 
}