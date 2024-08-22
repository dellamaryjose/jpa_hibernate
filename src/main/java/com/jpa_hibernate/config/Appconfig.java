package com.jpa_hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import com.jpa_hibernate.model.Sample;

@Configuration
public class Appconfig {

	@Autowired
	public Environment environment;
	
	
@Bean	
public PaymentService paymenetService() {
	
	
	var profile = Profiles.of("mysql");
	var isOkay = this.environment.acceptsProfiles(profile);
	String name = this.environment.getProperty("spring.application.name");
	System.out.println("Inside Payment Service bean method"+isOkay+"::"+name);
	return new PaymentService();
	
	
}

@Bean
@Qualifier("myBean")
public Sample myBean() {
	
	return new Sample();
}

@Bean
@Qualifier("mySecondBean")
public Sample mySecondBean() {
	
	return new Sample();
}

}
