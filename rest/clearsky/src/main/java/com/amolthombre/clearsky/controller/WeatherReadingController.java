package com.amolthombre.clearsky.controller;


import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amolthombre.clearsky.constants.URI;
import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;
import com.amolthombre.clearsky.service.WeatherReadingService;

@CrossOrigin
@RestController
@RequestMapping(value = URI.WEATHER_READINGS)
public class WeatherReadingController {
	
	WeatherReadingService weatherReadingService;
	private static final String CITY = "city";
	private static final String PROPERTY = "property";
	private static final String GRAIN = "grain";
	
	public WeatherReadingController(WeatherReadingService weatherReadingService) {
		this.weatherReadingService = weatherReadingService;
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public WeatherReading createWeatherReading(@RequestBody WeatherReading weatherReading) {		
		return weatherReadingService.create(weatherReading);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = URI.CITIES)
	public List<String> getListOfCities() {
		return weatherReadingService.listOfCities();
	}
	
	@RequestMapping(method = RequestMethod.GET, params = CITY)
	public WeatherReading getWeatherForCity(@RequestParam(CITY) String city) {
		return weatherReadingService.weatherForGivenCity(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {CITY, PROPERTY})
	public int getWeatherPropertyForCity(@RequestParam("city") String city, @RequestParam(PROPERTY) String property) throws Exception {		
		return weatherReadingService.getWeatherPropertyForCity(city, property);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {CITY, GRAIN})
	public List<AverageWeather> getAverageForCity(@RequestParam(CITY) String city, @RequestParam(GRAIN) String grain) {
		return weatherReadingService.getAverageWeatherForCity(city, grain);
	}
}