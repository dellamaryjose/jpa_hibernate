package com.jpa_hibernate.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "emp_mysql")
public class Employee {

	@EqualsAndHashCode.Exclude
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonProperty("emp-id")
	private int empId;
	private String name;
	@EqualsAndHashCode.Exclude
	private int age;
	@EqualsAndHashCode.Exclude
	private int salary;
	@EqualsAndHashCode.Exclude
	@Column(unique=true)
	private String email;
	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy="employee",
	cascade=CascadeType.ALL)
	private Address address;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	
	

}
