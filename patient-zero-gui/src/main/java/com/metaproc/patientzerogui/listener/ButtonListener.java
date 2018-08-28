package com.metaproc.patientzerogui.listener;

import com.metaproc.patientzerogui.controllers.RobotControlCenter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Getter
@Setter
@NoArgsConstructor
public class ButtonListener implements java.awt.event.ActionListener {

	private RobotControlCenter robotControlCenter;

	public void actionPerformed ( java.awt.event.ActionEvent evt ) {

		log.debug( "button pressed" );

		switch( evt.getActionCommand() ) {
			case "Start GMX":
				log.debug( "switched 'Start GMX'" );
				robotControlCenter.start();
				break;
			case "take Screenshot":
				log.debug( "switched take screenshot" );
				robotControlCenter.takeScreenshot();
				break;
			case "Stop":
				robotControlCenter.stop();
				break;
		}

	}
}
