package com.abromand.patientzerorpa.appservices.gmx;

import com.abromand.patientzerorpa.appservices.gmx.pages.EmailPage;
import com.abromand.patientzerorpa.appservices.gmx.pages.HomePage;
import com.abromand.patientzerorpa.appservices.gmx.pages.SignInPage;
import com.abromand.patientzerorpa.appservices.gmx.pages.WriteEmailPage;
import com.abromand.patientzerorpa.appservices.base.RpaRobot;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.basics.Debug;
import org.sikuli.script.Image;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Setter
public class GmxRobot extends RpaRobot {

	private Properties pageProperties;
	private Screen screen;

	public GmxRobot() {
		loadProperties( "/appservices/gmx/gmx.properties" );

		//Debug.on(3);

		prepare();
	}

	private void prepare() {
		String clazz = this.getClass().getCanonicalName();
		clazz = System.getProperty("user.home") + File.separator + "patientzero";
		String imgFolder = pageProperties.getProperty( "gmx.image.folder" );
		String inJarFolder = clazz + imgFolder;
		if (ImagePath.add(inJarFolder)) {
			log.info("Image Folder in jar at: " + inJarFolder);
		} else {
			log.error("Image Folder in jar not possible: " + inJarFolder);
		}
		screen = new Screen();

	}

	@Override
	public void execute() {

		//prepare();

		log.debug( "doGMX" );

		String username = pageProperties.getProperty( "gmx.signinpage.username" );
		String password = pageProperties.getProperty( "gmx.signinpage.password" );

		SignInPage gmx_sign_in_page = new SignInPage(screen, pageProperties);
		HomePage gmx_home_page = gmx_sign_in_page.signIn( username, password );
		EmailPage gmx_email_page = gmx_home_page.switchToEmail();
		WriteEmailPage gmx_write_email_page = gmx_email_page.writeMail();

		gmx_email_page = gmx_write_email_page.sendMail( params.get("emailAddress"), params.get("emailSubject"), params.get("emailBody"));
		gmx_email_page.logout();


	}

	public void loadProperties( String propertiesLocation ){
		pageProperties = new Properties();
		InputStream properties_input_stream = this.getClass().getResourceAsStream( propertiesLocation );
		try{
			pageProperties.load( properties_input_stream );
		} catch( IOException ioex ) {
			ioex.printStackTrace();
		}
	}


}
