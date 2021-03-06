package com.abromand.patientzerorpa.appservices.base;

import org.sikuli.script.Screen;

import java.util.Properties;

public class SikuliXPageObject{

	protected Properties pageProperties;
	protected Screen screen;

	public SikuliXPageObject() {
		this.screen = new Screen();
	}

	public SikuliXPageObject(Screen screen) {
		this.screen = screen;
	}

	public SikuliXPageObject( Screen screen, Properties properties ) {
		this( screen );
		pageProperties = properties;
	}

	public Screen getScreen() {
		return screen;
	}



	protected String getProperty( String key ) {
		return pageProperties.getProperty( key );
	}

	protected String img( String key )
	{
		return pageProperties.getProperty( key );
	}
}
