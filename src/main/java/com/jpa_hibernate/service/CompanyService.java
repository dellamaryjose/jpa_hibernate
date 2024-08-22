package com.jpa_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa_hibernate.model.Company;
import com.jpa_hibernate.repository.CompanyRepository;

@Service
public class CompanyService {

	private CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {

		this.companyRepository = companyRepository;
	}

	public Company createCompany(Company com) {

		return companyRepository.save(com);

	}

	public List<Company> getAll() {

		List<Company> companyList = companyRepository.findAll();

		return companyList;
	}

	public List<Company> getAllById(int id) {

		List<Company> companyList = companyRepository.findAllById(id);

		return companyList;
	}
}
