package com.metaproc.patientzerorpa.appservices.gmx;

import com.metaproc.patientzerorpa.appservices.gmx.pages.SignInPage;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.basics.Debug;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Controller
public class GmxController{

	private Properties pageProperties;
	private Screen screen;

	public GmxController() {
		loadProperties( "/appservices/gmx/gmx.properties" );

		String clazz = this.getClass().getCanonicalName();
		String imgFolder = pageProperties.getProperty( "gmx.image.folder" );
		String inJarFolder = clazz + imgFolder;
		if (ImagePath.add(inJarFolder)) {
			log.info("Image Folder in jar at: " + inJarFolder);
		} else {
			log.error("Image Folder in jar not possible: " + inJarFolder);
		}
		screen = new Screen();
	}

	public void doGMX( String emailAddress ) {

		log.debug( "doGMX" );

		String username = pageProperties.getProperty( "gmx.signinpage.username" );
		String password = pageProperties.getProperty( "gmx.signinpage.password" );

		SignInPage gmx_sign_in_page = new SignInPage(screen, pageProperties);
		gmx_sign_in_page.sign_in( username, password );
//		HomePage gmx_home_page = gmx_sign_in_page.sign_in( username, password );
//		EmailPage gmx_email_page = gmx_home_page.switch_to_mail();
//		WriteEmailPage gmx_write_email_page = gmx_email_page.write_mail();
//		gmx_write_email_page.send_email( emailAddress );

	}

	public Properties loadProperties( String propertiesLocation ){
		pageProperties = new Properties();
		InputStream properties_input_stream = this.getClass().getResourceAsStream( propertiesLocation );
		try{
			pageProperties.load( properties_input_stream );
			return pageProperties;
		} catch( IOException ioex ) {
			return null;
		}
	}


}
