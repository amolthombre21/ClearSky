package com.amolthombre.clearsky.repository.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.amolthombre.clearsky.entity.AverageWeather;
import com.amolthombre.clearsky.entity.WeatherReading;
import com.amolthombre.clearsky.repository.WeatherReadingRepository;

@Repository
public class WeatherReadingRepositoryImpl implements WeatherReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public WeatherReading create(WeatherReading weatherReading) {
        entityManager.persist(weatherReading.getWind());
        weatherReading.setWind(weatherReading.getWind());
        entityManager.persist(weatherReading);
        return weatherReading;
    }

    @Override
    public List<String> listOfCities() {
        Query query = entityManager
                .createNamedQuery("WeatherReading.allCities");
        return query.getResultList();
    }

    @Override
    public WeatherReading weatherForGivenCity(String city) {
        TypedQuery<WeatherReading> query = entityManager.createNamedQuery(
                "WeatherReading.city", WeatherReading.class);
        query.setParameter("givenCity", city);
        return query.getResultList().get(0);
    }

	@Override
	public List<AverageWeather> getHourlyAverageWeatherForCity(String city) {
		List<AverageWeather> weatherList = new ArrayList<AverageWeather>();
		Query query = entityManager.createNativeQuery("select AVG(wr.humidity), AVG(wr.pressure), AVG(wr.temperature), AVG(w.degree), AVG(w.speed), wr.timestamp from WeatherReading wr, Wind w where wr.city = ? group by HOUR(timestamp)");
		query.setParameter(1,city);
		List<Object[]> results = query.getResultList();		 
		results.stream().forEach((record) -> {		        
		        double humidityAvg = ((BigDecimal)record[0]).doubleValue();
		        double pressureAvg = ((BigDecimal)record[1]).doubleValue();
		        double temperatureAvg = ((BigDecimal)record[2]).doubleValue();
		        double degreeAvg = ((BigDecimal)record[3]).doubleValue();
		        Timestamp timestamp = (Timestamp)record[5];
		        double speedAvg = (double)record[4];		        
		        weatherList.add(new AverageWeather(humidityAvg,pressureAvg,temperatureAvg,degreeAvg,speedAvg,timestamp));		        
		});
		return weatherList;
	}

	@Override
	public List<AverageWeather> getDailyAverageWeatherForCity(String city) {
		List<AverageWeather> weatherList = new ArrayList<AverageWeather>();
		Query query = entityManager.createNativeQuery("select AVG(wr.humidity), AVG(wr.pressure), AVG(wr.temperature), AVG(w.degree), AVG(w.speed), wr.timestamp from WeatherReading wr, Wind w where wr.city = ? group by DATE(timestamp)");
		query.setParameter(1,city);
		List<Object[]> results = query.getResultList();		 
		results.stream().forEach((record) -> {		        
		        double humidityAvg = ((BigDecimal)record[0]).doubleValue();
		        double pressureAvg = ((BigDecimal)record[1]).doubleValue();
		        double temperatureAvg = ((BigDecimal)record[2]).doubleValue();
		        double degreeAvg = ((BigDecimal)record[3]).doubleValue();
		        Timestamp timestamp = (Timestamp)record[5];
		        double speedAvg = (double)record[4];		        
		        weatherList.add(new AverageWeather(humidityAvg,pressureAvg,temperatureAvg,degreeAvg,speedAvg,timestamp));		        
		});
		return weatherList;
	}
}