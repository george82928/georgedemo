package com.george.springboot.service;

import com.george.springboot.model.Weather;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface WeatherService {

	Weather findWeatherByNameAndCountry(String city) throws UnirestException;
}
