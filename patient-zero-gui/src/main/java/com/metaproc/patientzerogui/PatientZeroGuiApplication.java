package com.metaproc.patientzerogui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.metaproc.patientzerorpa", "com.metaproc.patientzerogui"})
//@SpringBootApplication
public class PatientZeroGuiApplication{

	public static void main( String[] args ){

		SpringApplicationBuilder builder = new SpringApplicationBuilder(PatientZeroGuiApplication.class);
		ApplicationContext context = builder.headless(false).run(args);
		// ApplicationContext context = SpringApplication.run( PatientZeroGuiApplication.class, args );

//		for(String name : context.getBeanDefinitionNames()){
//			System.out.println("name: " + name);
//		}

	}
}
