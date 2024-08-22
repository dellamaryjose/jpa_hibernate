package com.jpa_hibernate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
@PropertySource("classpath:applicaton.properties")
public class PaymentService {
	@Value("${spring.application.name}")
	private String dbUrl;
	public void display() {
		
		System.out.println("From PaymentService"+dbUrl);
	}
}
