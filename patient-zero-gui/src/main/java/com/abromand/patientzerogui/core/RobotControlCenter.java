package com.abromand.patientzerogui.core;

import com.abromand.patientzerogui.listener.ButtonListener;
import com.abromand.patientzerogui.worker.RpaWorker;
import com.abromand.patientzerorpa.appservices.base.RpaRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashMap;

@Slf4j
@Component
public class RobotControlCenter extends JFrame{


	private HashMap<String, RpaRobot> robots = new HashMap<>();
	private RpaWorker rpaWorker;

	private JPanel robotButtonList = new JPanel();

	private ButtonListener buttonListener;

	public RobotControlCenter( ButtonListener bl ){
		this.buttonListener = bl;

		initComponents();
		injectSelf();
	}

	public void addRobot(String command, RpaRobot rpaRobot) {
		robots.put( command, rpaRobot );
		JButton robotButton = new JButton( command );
		buttonListener.addButton( robotButton, rpaRobot );
		robotButtonList.add( robotButton );
	}

	private void setRpaRobotParams(String command, HashMap<String, String> params){
		robots.get( command ).setParams( params );
	}

	private void injectSelf() {
		buttonListener.setRobotControlCenter(this);
	}

	private void initComponents () {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout( new java.awt.BorderLayout() );
		this.setTitle( "Patient Zero" );

		JLabel title = new JLabel( "Patient Zero" );

		robotButtonList.setLayout( new java.awt.GridLayout(0, 1) );

		//this.add( title, java.awt.BorderLayout.PAGE_START );
		//this.add( doGmx, java.awt.BorderLayout.PAGE_START);
		this.add(robotButtonList, java.awt.BorderLayout.CENTER);
		//this.add(jButton2, java.awt.BorderLayout.PAGE_END);
		// this.add(jButton3, java.awt.BorderLayout.LINE_START);
		// this.add(jTextArea, java.awt.BorderLayout.CENTER);
		// this.add(jButton5, java.awt.BorderLayout.LINE_END);


		this.pack();
		this.setSize(300,200);
	}

	public void start( RpaRobot rpaRobot ) {
		log.debug( "starting worker" );
		rpaWorker = new RpaWorker( rpaRobot );
		rpaWorker.execute();
		log.debug( "worker started" );
	}

	public void stop() {
		rpaWorker.cancel( true );
	}

//	public void start() {
//		//rpaWorker.execute();
//		log.debug( "execute GmxWorker" );
//		gmxWorker = new GmxWorker(gmxController);
//		gmxWorker.execute();
//	}

//	public void takeScreenshot() {
//		log.debug( "execute take screenshot" );
//		rpaWorker = new RpaWorker(rpaRobot);
//		try {
//			rpaWorker.execute();
//			log.debug( "executed screenshot" );
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//rpaWorker.cancel( false );
//	}

}
