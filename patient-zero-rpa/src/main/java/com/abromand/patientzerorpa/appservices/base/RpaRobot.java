package com.abromand.patientzerorpa.appservices.base;

import java.util.HashMap;

public abstract class RpaRobot{

	protected HashMap<String, String> params;

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	public abstract void execute();
}
