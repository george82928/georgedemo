package com.george.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for handling view
 * 
 * @author George Zheng
 *
 */
@Controller
public class AppController {

	/**
	 * Method or handing view
	 * @return String of the view name
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home() {
		return "index";
	}

}
