package com.jpa_hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa_hibernate.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	public Employee findByName(String name);
	public List<Employee> findAllByNameContaining(String name);

}
