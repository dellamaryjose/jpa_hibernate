package com.jpa_hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa_hibernate.model.Employee;
import com.jpa_hibernate.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	EmployeeRepository employeeRepository ;
	
	
	public EmployeeService(	EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
		
	}
	
	public Employee getEmployeeById(int id) {
		
		Employee emp = employeeRepository.findById(id).get();
		
		return emp;
	}
	
	public Employee createEmployee(Employee emp) {
		
		
		Employee employee = employeeRepository.save(emp);
		
		return employee;
	}
	
	
	public Employee getEmpByName (String name) {
		
		Employee empByName = employeeRepository.findByName(name);
		return empByName;
		
	}
public List<Employee> getEmpListByName (String name) {
		
		List<Employee> empByNameList = employeeRepository.findAllByNameContaining(name);
		return empByNameList;
		
	}

public void deleteEmp(Integer id) {
	
	
 employeeRepository.deleteById(id.intValue());
	
}
	

}
