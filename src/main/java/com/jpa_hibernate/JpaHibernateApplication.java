package com.jpa_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.jpa_hibernate.config.PaymentService;
import com.jpa_hibernate.model.Sample;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext cx =  SpringApplication.run(JpaHibernateApplication.class, args);
		
	}
	
}
