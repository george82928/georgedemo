package com.george.springboot.model;

/**
 * Class of the Weather data
 * 
 * @author George Zheng
 *
 */
public class Weather {

	String city;
	long updatedTime;
	String weather;
	String temperature;
	String wind;

	/**
	 * Get city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set city
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get updatedTime
	 * @return the updatedTime
	 */
	public long getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * Set updatedTime
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(long updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * Get weather value
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * Set weather data
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * Get temperature
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * Set temperature
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * Get wind speed
	 * @return the wind
	 */
	public String getWind() {
		return wind;
	}

	/**
	 * Set wind speed 
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}
}
