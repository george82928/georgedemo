package com.george.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.george.springboot.model.Weather;
import com.george.springboot.service.WeatherService;
import com.george.springboot.util.CustomErrorType;

/**
 * Controller for handling REST API calls
 * 
 * @author George Zheng
 *
 */
@RestController
@RequestMapping("/weather")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	WeatherService weatherService;

	/**
	 * Method for getting the weather data
	 * @param city Name of the city
	 * @return {@code ResponseEntity} ResponseEntity with weather data
	 */
	@RequestMapping(value = "/{city}", method = RequestMethod.GET)
	public ResponseEntity<?> getWeather(@PathVariable("city") String city) {
		logger.info("Fetching Weather with city {}", city);
		Weather weather = null;
		try {
			weather = weatherService.findWeatherByNameAndCountry(city);

			if (weather == null) {
				logger.error("Weather with city {} not found", city);
				return new ResponseEntity<Object>(new CustomErrorType("Weather of city " + city + " not found"),
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(new CustomErrorType("Server error occurred"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Weather>(weather, HttpStatus.OK);
	}

}
