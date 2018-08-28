package com.metaproc.patientzerorpa.appservices.gmx.pages;

import com.metaproc.patientzerorpa.appservices.base.SikuliXPageObject;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

@Slf4j
public class SignInPage extends SikuliXPageObject{

	private Pattern logo;
	private Pattern freeMailSection;
	private Pattern emailAddressField;
	private Pattern passworField;
	private Pattern loginButton;

	public SignInPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);

		this.timeout = Integer.parseInt( getProperty( "gmx.timeout" ) );
		this.imageFolder = getProperty( "gmx.image.folder" );

		logo = new Pattern(img("gmx.logo")).similar(0.9);
		freeMailSection = new Pattern(img("gmx.signinpage.freeMailSection")).similar(0.9);
		emailAddressField = new Pattern(img("gmx.signinpage.emailAddressField")).similar(0.9);
		passworField = new Pattern(img("gmx.signinpage.passworField")).similar(0.9);
		loginButton = new Pattern(img("gmx.signinpage.loginButton")).similar(0.9);
	}

	private Boolean assertPage() {
		Match assertMatch;

//		log.debug("google logo file: " + img("google.logo"));
//
//		Pattern pattern = new Pattern(img("google.logo")).similar(0.9);
//
//		log.debug("pattern: " + pattern.toString());
//		log.debug("screen: " + screen.toString());
//
//		assertMatch = screen.exists(pattern, timeout);
//		assertMatch.highlight( timeout );

		assertMatch = screen.exists(logo, timeout);
		assertMatch.highlight( timeout );
		assertMatch = screen.exists(freeMailSection, timeout);
		assertMatch.highlight( timeout );
		return true;
	}

	public void sign_in(String username, String password) {
		try{

			if (!assertPage()) {
				throw new FindFailed("page assertion failed");
			}
			screen.wait( 2.0 );

			screen.click(emailAddressField);
			screen.wait( 2.0 );
			screen.click();
			screen.wait( 2.0 );

			screen.paste(getProperty( "gmx.signinpage.username" ));
//			screen.paste( "@" );
			screen.wait( 2.0 );

			screen.click(passworField);
			screen.wait( 2.0 );

			screen.write(getProperty( "gmx.signinpage.password" ));
			screen.wait( 2.0 );

			screen.click(loginButton);
			screen.wait( 2.0 );

		} catch(FindFailed findFailed){
			findFailed.printStackTrace();
		}
	}

}
