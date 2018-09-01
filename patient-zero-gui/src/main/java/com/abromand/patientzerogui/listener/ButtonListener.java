package com.abromand.patientzerogui.listener;

import com.abromand.patientzerogui.core.RobotControlCenter;
import com.abromand.patientzerorpa.appservices.base.RpaRobot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashMap;

@Slf4j
@Component
@Getter
@Setter
@NoArgsConstructor
public class ButtonListener implements java.awt.event.ActionListener {

	private RobotControlCenter robotControlCenter;
	private HashMap<String, RpaRobot> actionList = new HashMap<>();

	public void addButton( JButton button, RpaRobot rpaRobot ) {
		button.addActionListener( this );
		actionList.put( button.getText(), rpaRobot );
	}

	public void actionPerformed ( java.awt.event.ActionEvent evt ) {

		log.debug( "button pressed" );

		String action = evt.getActionCommand();
		robotControlCenter.start( actionList.get( action ) );

//		switch(  ) {
//			case "Start GMX":
//				log.debug( "switched 'Start GMX'" );
//				robotControlCenter.start();
//				break;
//			case "take Screenshot":
//				log.debug( "switched take screenshot" );
//				robotControlCenter.takeScreenshot();
//				break;
//			case "Stop":
//				robotControlCenter.stop();
//				break;
//		}

	}
}
