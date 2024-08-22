package com.jpa_hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa_hibernate.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	public List<Company> findAllById(int id);

}
