package com.rajat.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class locationController {
	@RequestMapping("/showCreate")
	public String showCreate() {
		//this function will just return jsp page to end user
		return "createLocation";
	}
}
