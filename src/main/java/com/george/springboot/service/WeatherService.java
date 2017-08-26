package com.george.springboot.service;

import com.george.springboot.model.Weather;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Service used to get weather data from open weather map api
 * 
 * @author George Zheng
 *
 */
public interface WeatherService {
	/**
	 * Get the weather data from open weather map api
	 * @param city City name
	 * @return {@code Weather} object
	 * @throws UnirestException
	 */
	Weather findWeatherByNameAndCountry(String city) throws UnirestException;
}
