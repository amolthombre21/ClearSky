package com.amolthombre.clearsky.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;
import com.amolthombre.clearsky.repository.WeatherReadingRepository;
import com.amolthombre.clearsky.service.WeatherReadingService;

@Service
public class WeatherServiceImpl implements WeatherReadingService {

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
    public WeatherReading weatherForGivenCity(String city) throws Exception {
        final WeatherReading weatherReading = weatherReadingRepository
                .weatherForGivenCity(city);
        if (weatherReading != null)
            return weatherReading;
        else
            throw new Exception();
    }

    @Override
    public int getWeatherPropertyForCity(String city, String property)
            throws Exception {
        WeatherReading weatherReading = weatherForGivenCity(city);
        int specificProperty;
        if (property.equals("humidity"))
            specificProperty = weatherReading.getHumidity();
        else if (property.equals("pressure"))
            specificProperty = weatherReading.getPressure();
        else if (property.equals("temperature"))
            specificProperty = weatherReading.getTemperature();
        else
            throw new Exception();
        return specificProperty;
    }

    @Override
    public List<AverageWeather> getAverageWeatherForCity(String city,
            String grain) throws Exception {
        if (grain.equals("hourly"))
            return weatherReadingRepository
                    .getHourlyAverageWeatherForCity(city);
        else if (grain.equals("daily"))
            return weatherReadingRepository.getDailyAverageWeatherForCity(city);
        else
            throw new Exception();
    }
}