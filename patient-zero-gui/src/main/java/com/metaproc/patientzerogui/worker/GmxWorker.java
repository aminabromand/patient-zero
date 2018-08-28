package com.metaproc.patientzerogui.worker;

import com.metaproc.patientzerorpa.appservices.gmx.GmxController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class GmxWorker extends SwingWorker<Integer, String>{
	private GmxController gmxController;

	protected Integer doInBackground() throws Exception {
		log.debug( "GmxWorker doInBackground" );
		try {
			gmxController.doGMX( "amin.abromand@metaproc.com" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
