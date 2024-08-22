package com.jpa_hibernate.util;

import org.springframework.stereotype.Service;

import com.jpa_hibernate.model.Address;
import com.jpa_hibernate.model.Company;
import com.jpa_hibernate.model.Employee;
import com.jpa_hibernate.model.EmployeeDto;
import com.jpa_hibernate.model.EmployeeResponseDto;


public class EmployeeUtil {

	
	
	
	public static Employee toEmployee(EmployeeDto empDto) {
		System.out.println("Inside util method--");
		var employee = new Employee();
		employee.setName(empDto.name());
		employee.setAge(empDto.age());
		employee.setEmail(empDto.email());
		employee.setSalary(empDto.salary());
		
		Company cmp = new Company();
		cmp.setId(empDto.cmpId());
		employee.setCompany(cmp);
		//System.out.println(cmp.getId()+":::"+empDto.cmpId());
		Address address = new Address();
		address.setDetail(empDto.adrDetails());
		employee.setAddress(address);

		
		return employee;
	}
	
public static EmployeeResponseDto toEmployeeResponse(Employee emp) {
		
		var employeeResponse = new EmployeeResponseDto(emp.getName(),
				emp.getEmail(),
				emp.getCompany().getId(),
				emp.getEmpId());	
		return employeeResponse;
	}
}
