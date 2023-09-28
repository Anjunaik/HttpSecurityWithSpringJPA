package com.acoder.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRest {

	@GetMapping(value="/welcome")
	public String whish()
	{
		return "Welcome";
	}
	
}
