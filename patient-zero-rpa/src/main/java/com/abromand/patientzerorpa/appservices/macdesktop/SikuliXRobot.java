package com.abromand.patientzerorpa.appservices.macdesktop;

import com.abromand.patientzerorpa.appservices.base.RpaRobot;
import lombok.extern.slf4j.Slf4j;
import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Slf4j
@Component
public class SikuliXRobot extends RpaRobot{

	public SikuliXRobot() {
		//OpenCV.loadShared();
		//OpenCV.loadLibrary();
		//System.out.println(Core.NATIVE_LIBRARY_NAME);
//		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		prepare();
	}

	private void prepare() {
		//		logThings4();

		String clazz = this.getClass().getCanonicalName();
		clazz = System.getProperty("user.home") + File.separator + "patientzero";
		String imgFolder = "/appservices/imgs";

		String inJarFolder = clazz + imgFolder;
		System.out.println("Adding Image Folder: " + inJarFolder);
		log.info("Adding Image Folder: " + inJarFolder);

		if (ImagePath.add(inJarFolder)) {
			log.info("Image Folder in jar at: " + inJarFolder);
		} else {
			log.error("Image Folder in jar not possible: "+ inJarFolder);
		}

		List<ImagePath.PathEntry> paths = ImagePath.getPaths();
		log.debug("Paths size: " + paths.size());

		int i = 0;
		for (ImagePath.PathEntry path : paths) {
			log.debug(i + " - looping... - :> ");
			if (path != null) {
				log.debug(path.toString());

			}
			else {
				log.debug("path is null");
			}
			i++;
		}
	}

//	public void logThings4() {
//		String imgFolder = System.getProperty("user.home") + File.separator + "patientzero";
//		String outJarFolder = imgFolder + File.separator + "imgs";
//
//		if (ImagePath.add(outJarFolder)) {
//			log.info("Image Folder in jar at: " + outJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ outJarFolder);
//		}
//	}
//
//	public void logThings3() {
//		String imgFolder = "/Users/amin/Train/imgs";
//
//		String inJarFolder = imgFolder;
//
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//	}
//
//	public void logThings2() {
//		String clazz = "com.abromand.TestGui";
//		String imgFolder = "/imgs";
//
//		String inJarFolder = clazz + imgFolder;
//
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//
//		clazz = "com.abromand.TestRpa";
//		imgFolder = "/imgs";
//
//		inJarFolder = clazz + imgFolder;
//
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//	}
//
//	public void logThings(String clazz, String imgFolder) {
//
//		String inJarFolder = clazz + imgFolder;
//
//		log.debug( "main - getClass.getResource: " + this.getClass().getResource( "/appservices/imgs/finder.png" ) );
//		log.debug( "main - getClass.getResource: " + this.getClass().getResource( "/appservices/imgs/finder2.png" ) );
//		log.debug( "main - getClass.getProtectionDomain.getCodeSource.getLocation: " + this.getClass().getProtectionDomain().getCodeSource().getLocation() );
//
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//
//		inJarFolder = "com.abromand.patientzerogui.PatientZeroGuiApplication" + imgFolder;
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//
//		inJarFolder = this.getClass().getProtectionDomain().getCodeSource().getLocation() + clazz + imgFolder;
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//
//		inJarFolder = imgFolder;
//		if (ImagePath.add(inJarFolder)) {
//			log.info("Image Folder in jar at: " + inJarFolder);
//		} else {
//			log.error("Image Folder in jar not possible: "+ inJarFolder);
//		}
//	}

	@Override
	public void execute() {
		prepare();
		log.debug( "robot take screenshot" );
		takeScreenshot();
//		test();
	}

	private void takeScreenshot() {
		Screen s = new Screen();

		try{
			s.wait( 1.0 );
			ScreenImage userCapture = s.userCapture();
			String clazz = System.getProperty("user.home") + File.separator + "patientzero" + File.separator + "screenshots";
			//userCapture.save( "/Users/amin/Train/patient-zero/patient-zero-rpa/src/main/resources/screenshots/", "screenshot" );
			userCapture.save( clazz, "screenshot" );
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
			return;
		}

		Debug.info("Found: %s at %s", img, target);
		s.hover();
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
