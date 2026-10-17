package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/one",method = RequestMethod.GET)
	public String sayOne() {
		 return "one";
	}
	
	@RequestMapping(value = "/two",method = RequestMethod.GET)
	public String sayTwo() {
		 return "two";
	}

	
}
