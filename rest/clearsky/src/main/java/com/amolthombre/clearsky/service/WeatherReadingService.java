package com.amolthombre.clearsky.service;

import java.util.List;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;

public interface WeatherReadingService {

    /**
     * Creates a {@link WeatherReading} object and stores it into database.
     * 
     * @param weatherReading
     *            {@link WeatherReading} object
     * @return {@link WeatherReading} object
     */
    public WeatherReading create(WeatherReading weatherReading);

    /**
     * Returns list of unique cities
     * 
     * @return {@link List} of {@link String}
     */
    public List<String> listOfCities();

    /**
     * Returns {@link WeatherReading} for a given city
     * 
     * @param city
     *            The name of city for which weather is requested
     * @return {@link WeatherReading} object
     */
    public WeatherReading weatherForGivenCity(String city) throws Exception;

    /**
     * Returns specific property for a city
     * 
     * @param city
     *            The name of city for which weather property is requested
     * @param property
     *            property The name of the weather property
     * @return int weather property
     * @throws Exception
     *             when property is not from humidity, pressure, and temperature
     */
    public int getWeatherPropertyForCity(String city, String property)
            throws Exception;

    /**
     * Returns {@link List} of {@link AverageWeather} object which contains
     * daily or hourly weather average
     * 
     * @param city
     *            The name of city for which average weather is requested
     * @param grain
     *            Can be hourly or daily
     * @return {@link List} of {@link AverageWeather}
     */
    public List<AverageWeather> getAverageWeatherForCity(String city,
            String grain) throws Exception;
}