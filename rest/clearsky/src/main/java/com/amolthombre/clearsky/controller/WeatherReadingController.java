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

    /**
     * Handles request for creating a new weather record {@link WeatherReading}
     * 
     * @param weatherReading
     *            object of {@link WeatherReading}
     * @return persisted {@link WeatherReading} object
     */
    @RequestMapping(method = RequestMethod.POST)
    public WeatherReading createWeatherReading(
            @RequestBody WeatherReading weatherReading) {
        return weatherReadingService.create(weatherReading);
    }

    /**
     * Handles request for returning list of cities
     * 
     * @return {@link List} of {@link String}
     */
    @RequestMapping(method = RequestMethod.GET, value = URI.CITIES)
    public List<String> getListOfCities() {
        return weatherReadingService.listOfCities();
    }

    /**
     * Handles request for returning weather for a given city
     * 
     * @param city
     *            The name of the city for which weather is requested
     * @return {@link WeatherReading} object
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, params = CITY)
    public WeatherReading getWeatherForCity(@RequestParam(CITY) String city)
            throws Exception {
        return weatherReadingService.weatherForGivenCity(city);
    }

    /**
     * Returns specific weather property for a given city
     * 
     * @param city
     *            The name of the city for which weather property is requested
     * @param property
     *            weather property from humidity, temperature,pressure
     * @return specific weather property
     * @throws Exception
     *             when property is not from humidity, temperature,pressure
     */
    @RequestMapping(method = RequestMethod.GET, params = { CITY, PROPERTY })
    public int getWeatherPropertyForCity(@RequestParam("city") String city,
            @RequestParam(PROPERTY) String property) throws Exception {
        return weatherReadingService.getWeatherPropertyForCity(city, property);
    }

    /**
     * Returns average weather forecast for a given city
     * 
     * @param city
     *            The name of the city for which average weather forecast is
     *            requested
     * @param grain
     *            grain is either hourly or daily
     * @return {@link List} of {@link AverageWeather}
     * @throws Exception
     *             when property is not from hourly or daily
     */
    @RequestMapping(method = RequestMethod.GET, params = { CITY, GRAIN })
    public List<AverageWeather> getAverageForCity(
            @RequestParam(CITY) String city, @RequestParam(GRAIN) String grain)
            throws Exception {
        return weatherReadingService.getAverageWeatherForCity(city, grain);
    }
}