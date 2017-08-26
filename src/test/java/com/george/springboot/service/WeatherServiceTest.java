package com.george.springboot.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;
import com.george.springboot.model.RestApiProperties;
import com.george.springboot.model.Weather;

/**
 * Unit test for WeatherService
 * 
 * @author George Zheng
 *
 */
public class WeatherServiceTest {

	private WeatherService weatherService;
	private RestApiProperties restApiProperties;
	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static final String COUNTRY = "au";
	private static final String CITY = "Melbourne";
	private static final String KEY = "f0ae30dc0473e56e792d187ce2d81175";
	
	@Before
	public void setUp() {
		restApiProperties = Mockito.mock(RestApiProperties.class);
		weatherService = new WeatherServiceImpl(restApiProperties);
	}
	
	@After
	public void tearDown() {
		weatherService = null;
		restApiProperties = null;
	}
	
	/**
	 * Test if the service can get weather data without error
	 * @throws Exception
	 */
	@Test
	public void testFindWeatherByNameAndCountry() throws Exception {
		Mockito.when(restApiProperties.getBaseurl()).thenReturn(BASE_URL);
		Mockito.when(restApiProperties.getCountry()).thenReturn(COUNTRY);
		Mockito.when(restApiProperties.getKey()).thenReturn(KEY);
		
		Weather weather = weatherService.findWeatherByNameAndCountry(CITY);
		Assert.assertNotNull(weather);
		Assert.assertNotNull(weather.getCity());
		Assert.assertNotNull(weather.getTemperature());
		Assert.assertNotNull(weather.getWeather());
		Assert.assertNotNull(weather.getWind());
		Assert.assertNotNull(weather.getCity());
		Assert.assertTrue(weather.getCity().equals(CITY));
		Assert.assertTrue(weather.getTemperature().length() > 0);
		Assert.assertTrue(weather.getWeather().length() > 0);
		Assert.assertTrue(weather.getWind().length() > 0);
		Assert.assertTrue(weather.getUpdatedTime() > 0);
	}
}
