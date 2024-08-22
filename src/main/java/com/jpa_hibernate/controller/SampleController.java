package com.jpa_hibernate.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_hibernate.model.Sample;

@RestController
@RequestMapping("/api/v1")
@PropertySource("classpath:custom.properties")
public class SampleController {

	Sample sample;
	@Value("${my.prop}")
	public String customVal;
	public SampleController(@Qualifier("mySecondBean") Sample sample) {
		
		this.sample = sample;
		System.out.println("FROM-----------"+customVal);
	}
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<String> getEmp(@PathVariable("id") String id)
	{
		sample.print();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customVal);
		
		
	}
}
