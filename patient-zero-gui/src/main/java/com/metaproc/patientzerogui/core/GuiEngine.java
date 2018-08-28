package com.metaproc.patientzerogui.core;

import com.metaproc.patientzerogui.controllers.RobotControlCenter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller
public class GuiEngine implements CommandLineRunner {

	private RobotControlCenter robotControlCenter;

	public GuiEngine( RobotControlCenter robotControlCenter ){
		this.robotControlCenter = robotControlCenter;
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
		this.start();
	}
}
