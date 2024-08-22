package com.jpa_hibernate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_hibernate.config.PaymentService;
import com.jpa_hibernate.model.Employee;
import com.jpa_hibernate.model.EmployeeDto;
import com.jpa_hibernate.model.EmployeeResponseDto;
import com.jpa_hibernate.service.EmployeeService;
import com.jpa_hibernate.util.EmployeeUtil;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private PaymentService paymentService;
	
	public EmployeeController(EmployeeService employeeService,PaymentService paymentService) {
		
		this.employeeService = employeeService;
		this.paymentService = paymentService;
	}
	
	
	@GetMapping("/getEmp/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		paymentService.display();
		return ResponseEntity.status(HttpStatus.ACCEPTED).
				body(employeeService.getEmployeeById(id));
		
	}

	@PostMapping("/addEmp")
	public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeDto empDto) {
		System.out.println("Inside controller---++"+empDto.cmpId());
		//return employeeService.createEmployee(emp);
		Employee emp = EmployeeUtil.toEmployee(empDto);
		System.out.println("Emp---"+emp);
		var savedEmp = employeeService.createEmployee(emp);
		EmployeeResponseDto response = EmployeeUtil.toEmployeeResponse(savedEmp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(response);
		
		
		
	}

	@GetMapping("/getEmpByName/{name}")
	public ResponseEntity<Employee> getByName (@PathVariable("name") String name){
		
		
		Employee empByName = employeeService.getEmpByName(name);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empByName);
	}
	@GetMapping("/getEmpList/{name}")
	public ResponseEntity<List<Employee>> getAllByName (@PathVariable("name") String name){
		
		
		List<Employee> empListByName = employeeService.getEmpListByName(name);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empListByName);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable Integer id){
		
		employeeService.deleteEmp(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(id);
		
		
	}
}
