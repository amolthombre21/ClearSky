package com.amolthombre.clearsky.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "WeatherReading.allCities", query = "select distinct wr.city from WeatherReading wr"),
	@NamedQuery(name = "WeatherReading.city", query = "select wr from WeatherReading wr where wr.city = :givenCity order by wr.timestamp desc"),
	@NamedQuery(name = "WeatherReading.hourlyAverage", query = "select AVG(wr.humidity), AVG(wr.pressure), AVG(wr.temperature), AVG(w.degree), AVG(w.speed), wr.timestamp from WeatherReading wr, Wind w where wr.city = :pCity group by DATE(timestamp), HOUR(timestamp)")
})
public class WeatherReading {
	@Id
	private String id;
	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int temperature;
	@OneToOne
	private Wind wind;
	private Timestamp timestamp;
	
	public WeatherReading() {
		this.id = UUID.randomUUID().toString();
	}
	public WeatherReading(String city, String description, int humidity,
			int pressure, int temperature, Wind wind, Timestamp timestamp) {
		this.id = UUID.randomUUID().toString();
		this.city = city;
		this.description = description;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temperature = temperature;
		this.wind = wind;
		this.timestamp = timestamp;
	}	 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}