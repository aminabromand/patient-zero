package com.abromand.patientzerogui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PatientZeroGuiApplicationTests{

	@Before
	public void startUp() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PatientZeroGuiApplication.class);
		ApplicationContext context = builder.headless(false).run();
	}

	@Test
	public void contextLoads(){
	}

}
