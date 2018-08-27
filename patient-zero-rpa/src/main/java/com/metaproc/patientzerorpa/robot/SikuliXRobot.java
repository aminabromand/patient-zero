package com.metaproc.patientzerorpa.robot;

import lombok.extern.slf4j.Slf4j;
import org.sikuli.basics.Debug;
import org.sikuli.script.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SikuliXRobot implements RpaRobot{

	String clazz = "com.metaproc.patientzerorpa.robot.SikuliXRobot";
	String imgFolder = "/sikulix/imgs";

	@Override
	public void init() {
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
