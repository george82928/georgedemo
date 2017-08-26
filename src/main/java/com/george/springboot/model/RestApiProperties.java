package com.george.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Object of REST API configuration data, values are from application.yml
 * 
 * @author George Zheng
 *
 */
@Component
@ConfigurationProperties("restapi")
public class RestApiProperties {

	private String baseurl;
	private String country;
	private String key;

	/**
	 * Get baseurl
	 * @return the baseurl
	 */
	public String getBaseurl() {
		return baseurl;
	}

	/**
	 * Set baseurl
	 * @param baseurl the baseurl to set
	 */
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	/**
	 * Get country
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set country value
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get key value
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set key value
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
