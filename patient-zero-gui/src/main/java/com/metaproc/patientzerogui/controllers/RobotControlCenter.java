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

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Component
public class RobotControlCenter extends Application implements CommandLineRunner{

	private RpaRobot rpaRobot;
	private SikuliXRobot sikuliXRobot;
	private TestBean testBean;

	public RobotControlCenter() {
		super();
	}

	public RobotControlCenter( RpaRobot rpaRobot, SikuliXRobot sikuliXRobot, TestBean testBean ){
		super();
		this.rpaRobot = rpaRobot;
		this.sikuliXRobot = sikuliXRobot;
		this.testBean = testBean;
	}

	public RpaRobot getRpaRobot(){
		return rpaRobot;
	}

	public void setRpaRobot( RpaRobot rpaRobot ){
		this.rpaRobot = rpaRobot;
	}

	public SikuliXRobot getSikuliXRobot(){
		return sikuliXRobot;
	}

	public void setSikuliXRobot( SikuliXRobot sikuliXRobot ){
		this.sikuliXRobot = sikuliXRobot;
	}

	@Override
	public void start(Stage primaryStage) {



		//rpaRobot.init();
		System.out.println("Contains property rpaRobot: " + (rpaRobot != null));
		System.out.println("Contains property sikuliXRobot: " + (sikuliXRobot != null));
		System.out.println("Contains property testBean: " + (testBean != null));

		Button btnTakeScreenshot = new Button();
		btnTakeScreenshot.setText( "Screenshot" );

		Button btnStartRobot = new Button();
		btnStartRobot.setText( "Start Robot" );
		btnStartRobot.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				rpaRobot.execute();
			}
		});





		Label label = new Label("Patient Zero");

		StackPane root = new StackPane();
		root.getChildren().add(label);
		root.getChildren().add(btnTakeScreenshot);

		Scene scene = new Scene(root, 400, 300);

		primaryStage.setTitle("Hello JavaFX World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void run(String... args) {
		System.out.println("2 Contains property rpaRobot: " + (rpaRobot != null));
		System.out.println("2 Contains property sikuliXRobot: " + (sikuliXRobot != null));
		System.out.println("2 Contains property testBean: " + (testBean != null));

		//launch(args);

		System.out.println("3 Contains property rpaRobot: " + (rpaRobot != null));
		System.out.println("3 Contains property sikuliXRobot: " + (sikuliXRobot != null));
		System.out.println("3 Contains property testBean: " + (testBean != null));
	}

	public TestBean getTestBean(){
		return testBean;
	}

	public void setTestBean( TestBean testBean ){
		this.testBean = testBean;
	}
}
