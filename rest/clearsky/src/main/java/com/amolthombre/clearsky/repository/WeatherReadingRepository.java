package com.amolthombre.clearsky.repository;

import java.util.List;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;

public interface WeatherReadingRepository {

    /**
     * Persists {@link WeatherReading} into data store
     * 
     * @param weatherReading
     *            {@link WeatherReading} object
     * @return persisted {@link WeatherReading}
     */
    public WeatherReading create(WeatherReading weatherReading);

    /**
     * Returns {@link List} of {@link String} containing unique cities
     * 
     * @return {@link List} of {@link String}
     */
    public List<String> listOfCities();

    /**
     * Returns {@link WeatherReading} for a given city
     * 
     * @param city
     *            The name of the city for which weather is requested
     * @return {@link WeatherReading} object
     */
    public WeatherReading weatherForGivenCity(String city);

    /**
     * Returns {@link List} of {@link AverageWeather} hourly weather
     * 
     * @param city
     *            The name of the city for which hourly weather is requested
     * @return {@link List} of {@link AverageWeather}
     */
    public List<AverageWeather> getHourlyAverageWeatherForCity(String city);

    /**
     * Returns {@link List} of {@link AverageWeather} daily weather
     * 
     * @param city
     *            The name of the city for which daily weather is requested
     * @return {@link List} of {@link AverageWeather}
     */
    public List<AverageWeather> getDailyAverageWeatherForCity(String city);
}