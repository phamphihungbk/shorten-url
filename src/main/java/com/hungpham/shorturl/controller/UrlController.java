package com.hungpham.shorturl.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/url")
public class UrlController {

	@GetMapping()
	public String get() {
		return "hung";
	}

	@DeleteMapping()
	public Boolean remove(){
		return true;
	}


}
