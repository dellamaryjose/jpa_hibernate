package com.jpa_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_hibernate.model.Company;
import com.jpa_hibernate.service.CompanyService;

@RestController
@RequestMapping("/api/v1/cmp")
public class CompanyController {
	
	private CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		
		this.companyService = companyService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		System.out.println("CMPNy--"+company);
		Company newCmp = companyService.createCompany(company);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newCmp);
		
	}
	
	@GetMapping("/getList/{id}")
	
	public List<Company> getAllById(@PathVariable("id") Integer id){
		
		List<Company> list = companyService.getAllById(id);
		 return list;
	}
	
@GetMapping("/getList")
	
	public ResponseEntity<List<Company>> getAll(){
		
		List<Company> list = companyService.getAll();
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}

}
