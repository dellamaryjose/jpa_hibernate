package com.jpa_hibernate.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	@JsonManagedReference
	@OneToMany(mappedBy="company")
	private List<Employee> employee;

}
