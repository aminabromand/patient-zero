package com.metaproc.patientzerogui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.metaproc.patientzerorpa", "com.metaproc.patientzerogui"})
//@SpringBootApplication
public class PatientZeroGuiApplication{

	public static void main( String[] args ){

		ApplicationContext context = SpringApplication.run( PatientZeroGuiApplication.class, args );
		System.out.println("Contains RpaRobot  "+context.
						containsBeanDefinition("rpaRobot"));
		System.out.println("Contains SikuliXRobot  "+context.
						containsBeanDefinition("sikuliXRobot"));
		System.out.println("Contains TestBean  "+context.
						containsBeanDefinition("testBean"));
//		for(String name : context.getBeanDefinitionNames()){
//			System.out.println("name: " + name);
//		}

	}
}
