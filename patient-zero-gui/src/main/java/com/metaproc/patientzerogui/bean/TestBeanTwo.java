package com.metaproc.patientzerogui.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestBeanTwo implements CommandLineRunner{
	private TestBean testBean;

	public TestBeanTwo( TestBean testBean ){
		this.testBean = testBean;
	}

	@Override
	public void run(String... args) {
		System.out.println("testBean is not null: " + (testBean != null));
	}
}
