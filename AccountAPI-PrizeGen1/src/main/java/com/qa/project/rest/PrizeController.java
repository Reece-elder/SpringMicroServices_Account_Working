package com.qa.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.service.PrizeGenService;

@RestController
public class PrizeController {

	private PrizeGenService service;

	public PrizeController(PrizeGenService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/genPrize/{accNumber}")
	public String genPrize(@PathVariable String accNumber) {
		return String.valueOf(this.service.genPrize(accNumber));
	}
	
}
