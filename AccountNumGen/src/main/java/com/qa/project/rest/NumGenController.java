package com.qa.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.service.NumGenService;

@RestController 
public class NumGenController {

//	Creating the object 
	private NumGenService service;

//	Constructor for the controller 
	public NumGenController(NumGenService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/genNum")
	public String genNumber() {
		return this.service.genNumber();
	}
	
	
	
}
