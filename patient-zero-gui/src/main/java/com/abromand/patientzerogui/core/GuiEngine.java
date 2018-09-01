package com.abromand.patientzerogui.core;

import com.abromand.patientzerorpa.appservices.gmx.GmxRobot;
import com.abromand.patientzerorpa.appservices.macdesktop.SikuliXRobot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.util.HashMap;

@Controller
public class GuiEngine implements CommandLineRunner {

	private RobotControlCenter robotControlCenter;

	public GuiEngine( RobotControlCenter robotControlCenter ){
		this.robotControlCenter = robotControlCenter;
	}

	private void init() {
		robotControlCenter.addRobot( "Take Screenshot", new SikuliXRobot() );

		GmxRobot gmxController = new GmxRobot();

		HashMap<String, String> params = new HashMap<>();
		params.put( "emailAddress", "amin.abromand@abromand.com");
		params.put( "emailSubject", "patient zero");
		params.put( "emailBody", "hello from patient zero");

		gmxController.setParams( params );

		robotControlCenter.addRobot( "Start GMX", gmxController );
	}

	private void start() throws Exception{
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				robotControlCenter.setVisible ( true );
			}
		});
	}

	@Override
	public void run( String... args ) throws Exception{
		this.init();
		this.start();
	}
}
