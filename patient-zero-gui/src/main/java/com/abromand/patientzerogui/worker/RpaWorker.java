package com.abromand.patientzerogui.worker;

import com.abromand.patientzerorpa.appservices.base.RpaRobot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class RpaWorker extends SwingWorker<Integer, String>{

	private RpaRobot rpaRobot;

	protected Integer doInBackground() {
		log.debug( "worker execute screenshot" );
		try {
			rpaRobot.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
