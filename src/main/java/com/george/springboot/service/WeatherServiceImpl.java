package com.george.springboot.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.george.springboot.model.RestApiProperties;
import com.george.springboot.model.Weather;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private RestApiProperties restApiProperties;

	private static final String REST_API_COMMA = ",";
	private static final String REST_API_KEY = "&APPID=";
	private static final String JSON_KEY_CITY_NAME = "name";
	private static final String JSON_KEY_WEATHER = "weather";
	private static final String JSON_KEY_MAIN = "main";
	private static final String JSON_KEY_TEMP = "temp";
	private static final String JSON_KEY_TEMP_KELVIN = "273.15";
	private static final String JSON_KEY_TEMP_CELSIUS_SIGN = "°C";
	private static final String JSON_KEY_UPDATED_TIME = "dt";
	private static final String JSON_KEY_WIND = "wind";
	private static final String JSON_KEY_WIND_SPEED = "speed";
	private static final String JSON_KEY_WIND_KMH = "km/h";

	@Override
	public Weather findWeatherByNameAndCountry(String city) throws UnirestException {
		Weather weather = null;
		HttpResponse<JsonNode> jsonResponse = Unirest
				.get(restApiProperties.getBaseurl() 
					 + city 
					 + REST_API_COMMA 
					 + restApiProperties.getCountry()
					 + REST_API_KEY 
					 + restApiProperties.getKey())
						.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).asJson();

		JSONObject jo = jsonResponse.getBody().getObject();
		if (jo != null) {
			weather = new Weather();
			weather.setCity(jo.getString(JSON_KEY_CITY_NAME));
			weather.setWeather(jo.getJSONArray(JSON_KEY_WEATHER).getJSONObject(0).getString(JSON_KEY_MAIN));
			double tempKelvin = jo.getJSONObject(JSON_KEY_MAIN).getDouble(JSON_KEY_TEMP);
			BigDecimal tempK = new BigDecimal(String.valueOf(tempKelvin));
			BigDecimal start = new BigDecimal(JSON_KEY_TEMP_KELVIN);
			weather.setTemperature(tempK.subtract(start).setScale(0, RoundingMode.HALF_UP).toString() 
					+ JSON_KEY_TEMP_CELSIUS_SIGN);
			weather.setUpdatedTime(jo.getLong(JSON_KEY_UPDATED_TIME));
			double windMeterPerSec = jo.getJSONObject(JSON_KEY_WIND).getDouble(JSON_KEY_WIND_SPEED);
			String wind = Math.round(windMeterPerSec * 3.6) + JSON_KEY_WIND_KMH;
			weather.setWind(wind);
		}
		return weather;
	}
}
