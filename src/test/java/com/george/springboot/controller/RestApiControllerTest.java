package com.george.springboot.controller;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.george.springboot.model.Weather;
import com.george.springboot.service.WeatherService;
import com.george.springboot.util.CustomErrorType;

/**
 * Unit test of Rest API controller
 * 
 * @author George Zheng
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = RestApiController.class, secure = false)
public class RestApiControllerTest {

	private Weather weather;
	private CustomErrorType customErrorType;

	@Before
	public void setUp() {
		weather = new Weather();
		weather.setCity("Melbourne");
		weather.setTemperature("15°C");
		weather.setUpdatedTime(120000);
		weather.setWeather("cloudy");
		weather.setWind("180km/h");
	}

	@After
	public void tearDown() {
		weather = null;
		customErrorType = null;
	}

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private WeatherService weatherService;

	private static final String REST_API = "/weather/Melbourne";

	/**
	 * Test getting weather data successfully
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetWeatherDataSuccessful() throws Exception {
		Mockito.when(weatherService.findWeatherByNameAndCountry(Mockito.anyString())).thenReturn(weather);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(REST_API).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String resultStr = result.getResponse().getContentAsString();
		JSONObject weatherJsonObj = new JSONObject(resultStr);

		Assert.assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());
		Assert.assertEquals(weather.getCity(), weatherJsonObj.getString("city"));
		Assert.assertEquals(weather.getTemperature(), weatherJsonObj.getString("temperature"));
		Assert.assertEquals(weather.getUpdatedTime(), weatherJsonObj.getLong("updatedTime"));
		Assert.assertEquals(weather.getWeather(), weatherJsonObj.getString("weather"));
		Assert.assertEquals(weather.getWind(), weatherJsonObj.getString("wind"));
	}

	/**
	 * Test getting null data
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNullData() throws Exception {
		customErrorType = new CustomErrorType("Weather of city Melbourne not found");
		Mockito.when(weatherService.findWeatherByNameAndCountry(Mockito.anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(REST_API).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String resultStr = result.getResponse().getContentAsString();
		JSONObject weatherJsonObj = new JSONObject(resultStr);

		Assert.assertEquals(result.getResponse().getStatus(), HttpStatus.NOT_FOUND.value());
		Assert.assertEquals(customErrorType.getErrorMessage(), weatherJsonObj.getString("errorMessage"));
	}

	/**
	 * Test getting server error
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInternalServerError() throws Exception {
		customErrorType = new CustomErrorType("Server error occurred");
		Mockito.when(weatherService.findWeatherByNameAndCountry(Mockito.anyString()))
				.thenThrow(new RuntimeException("Server error."));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(REST_API).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String resultStr = result.getResponse().getContentAsString();
		JSONObject weatherJsonObj = new JSONObject(resultStr);

		Assert.assertEquals(result.getResponse().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		Assert.assertEquals(customErrorType.getErrorMessage(), weatherJsonObj.getString("errorMessage"));
	}
}
