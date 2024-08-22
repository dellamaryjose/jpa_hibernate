package com.jpa_hibernate.model;

import jakarta.validation.constraints.NotEmpty;

public record EmployeeDto(
		@NotEmpty(message="Name should not be empty")
		String name,
		
		int age,
		
		int salary,
		
		String email,
		
		String  adrDetails,
		
		int cmpId
		
		) {

}
