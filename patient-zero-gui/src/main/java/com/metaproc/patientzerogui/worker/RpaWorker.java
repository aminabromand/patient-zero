package com.metaproc.patientzerogui.worker;

import com.metaproc.patientzerorpa.robot.RpaRobot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class RpaWorker extends SwingWorker<Integer, String>{

	private RpaRobot rpaRobot;

	protected Integer doInBackground() throws Exception {
		log.debug( "worker execute screenshot" );
		try {
			rpaRobot.init();
			rpaRobot.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
