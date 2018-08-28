package com.metaproc.patientzerorpa.robot;

import com.metaproc.patientzerorpa.appservices.gmx.GmxController;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SikuliXRobot implements RpaRobot{

	String clazz = this.getClass().getCanonicalName();
	String imgFolder = "/appservices/imgs";

	@Override
	public void init() {

		System.out.println(clazz);
		String inJarFolder = clazz + imgFolder;
		if (ImagePath.add(inJarFolder)) {
			log.info("Image Folder in jar at: %s", inJarFolder);
		} else {
			log.error("Image Folder in jar not possible: %s", inJarFolder);
		}


		List<ImagePath.PathEntry> paths = ImagePath.getPaths();
		System.out.println("Paths size: " + paths.size());

		int i = 0;
		for (ImagePath.PathEntry path : paths) {
			System.out.print(i + " - looping... - :> ");
			if (path != null) {
				System.out.println(path.toString());

			}
			else {
				System.out.println("path is null");
			}
			i++;
		}
	}

	@Override
	public void execute() {
		log.debug( "robot take screenshot" );
		takeScreenshot();
//		test();
	}

	private void takeScreenshot() {
		Screen s = new Screen();

		try{

			ScreenImage userCapture = s.userCapture();
			userCapture.save( "/Users/amin/Train/patient-zero/patient-zero-rpa/src/main/resources/screenshots/", "screenshot" );
			s.find( userCapture.getFile() ).highlight( 2 );
			log.debug( "took screenshot" );

		} catch(FindFailed findFailed){
			findFailed.printStackTrace();
			log.debug( "screenshot failed" );
		}

	}

	private void test() {
		Screen s = new Screen();
		Debug.info("Screen: %s", s);

		String img;
		Pattern testpattner;
		Match target;


		img = "recorded.png";
		testpattner = new Pattern(img).similar(0.9);
		target = s.exists(testpattner, 10);
		if (null == target) {
			Debug.error("Not found: %s", img);
		} else {
			Debug.info("Found: %s at %s", img, target);
			s.hover();
		}
		target.highlight( 2 );



		try{
			s.click("spotlight.png");
			s.wait("spotlight-input.png");
			s.click();
			s.write("hello world#ENTER.");
		}
		catch(FindFailed e){
			e.printStackTrace();
		}
	}


}
