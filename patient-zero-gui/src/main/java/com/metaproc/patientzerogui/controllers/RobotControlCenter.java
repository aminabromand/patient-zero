package com.metaproc.patientzerogui.controllers;

import com.metaproc.patientzerogui.listener.ButtonListener;
import com.metaproc.patientzerogui.worker.GmxWorker;
import com.metaproc.patientzerogui.worker.RpaWorker;
import com.metaproc.patientzerorpa.appservices.gmx.GmxController;
import com.metaproc.patientzerorpa.robot.RpaRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Slf4j
@Component
public class RobotControlCenter extends JFrame{

	//private RpaWorker rpaWorker;
	private RpaRobot rpaRobot;
	private RpaWorker rpaWorker;
	private GmxController gmxController;
	private GmxWorker gmxWorker;

	private JButton doGmx = new JButton( "Start GMX" );
	private JButton takeScreen = new JButton( "take Screenshot" );
	private JButton jButton2 = new JButton( "Start Process" );
	private JButton jButton3 = new JButton( "jButton3" );
	private JButton jButton4 = new JButton( "jButton4" );
	private JButton jButton5 = new JButton( "jButton5" );

	private JTextArea jTextArea = new JTextArea( "" );

	private ButtonListener buttonListener;

	public RobotControlCenter( GmxController gmxController, RpaRobot rpaRobot, ButtonListener bl ){
		this.gmxController = gmxController;
		this.rpaRobot = rpaRobot;
		this.buttonListener = bl;

		initComponents();
		injectSelf();
	}

	private void injectSelf() {
		buttonListener.setRobotControlCenter(this);
	}

	private void initComponents () {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout( new java.awt.BorderLayout() );


		JPanel jPanel1 = new JPanel();
		//doGmx = new javax.swing.JButton( "doGmx" );
		jPanel1.setLayout( new java.awt.GridLayout(2, 1) );
		jPanel1.add(takeScreen);
		jPanel1.add(doGmx);



		doGmx.addActionListener( buttonListener );
		takeScreen.addActionListener( buttonListener );
		jButton2.addActionListener( buttonListener );
		jButton3.addActionListener( buttonListener );
		jButton4.addActionListener( buttonListener );
		jButton5.addActionListener( buttonListener );


//		this.add( takeScreen, java.awt.BorderLayout.PAGE_START );
//		this.add( doGmx, java.awt.BorderLayout.PAGE_START);
		this.add(jPanel1, java.awt.BorderLayout.PAGE_START);
		//this.add(jButton2, java.awt.BorderLayout.PAGE_END);
		// this.add(jButton3, java.awt.BorderLayout.LINE_START);
		this.add(jTextArea, java.awt.BorderLayout.CENTER);
		// this.add(jButton5, java.awt.BorderLayout.LINE_END);

		pack();

		this.setSize(500,500);
	}

	public void start() {
		//rpaWorker.execute();
		log.debug( "execute GmxWorker" );
		gmxWorker = new GmxWorker(gmxController);
		gmxWorker.execute();
	}

	public void takeScreenshot() {
		log.debug( "execute take screenshot" );
		rpaWorker = new RpaWorker(rpaRobot);
		try {
			rpaWorker.execute();
			log.debug( "executed screenshot" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		//rpaWorker.cancel( false );
	}

	public void stop() {
		rpaWorker.cancel( true );
	}
}
