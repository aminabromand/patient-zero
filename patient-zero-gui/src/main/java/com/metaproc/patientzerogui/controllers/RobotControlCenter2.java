package com.metaproc.patientzerogui.controllers;

import com.metaproc.patientzerogui.bean.TestBean;
import com.metaproc.patientzerorpa.robot.RpaRobot;
import com.metaproc.patientzerorpa.robot.SikuliXRobot;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RobotControlCenter2 extends Application implements CommandLineRunner{
	private TestBean testBean;
	private RpaRobot rpaRobot;
	private SikuliXRobot sikuliXRobot;

	public RobotControlCenter2( ){
		super();
	}

	public RobotControlCenter2( TestBean testBean, RpaRobot rpaRobot, SikuliXRobot sikuliXRobot ){
		super();
		this.testBean = testBean;
		this.rpaRobot = rpaRobot;
		this.sikuliXRobot = sikuliXRobot;
	}

	@Override
	public void run(String... args) {
		System.out.println("RCC2 testBean is not null: " + (testBean != null));
		System.out.println("RCC2 rpaRobot is not null: " + (rpaRobot != null));
		System.out.println("RCC2 sikuliXRobot is not null: " + (sikuliXRobot != null));

		launch(args);
	}

//	@Override
//	public void start( Stage primaryStage ) throws Exception{
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root, 400, 300);
//		primaryStage.setTitle("Hello JavaFX World!");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}

	@Override
	public void start(Stage primaryStage) {



		Label label = new Label("Patient Zero");

		StackPane root = new StackPane();
		root.getChildren().add(label);

		Scene scene = new Scene(root, 400, 300);

		primaryStage.setTitle("Hello JavaFX World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
