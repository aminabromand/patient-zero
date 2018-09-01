package com.abromand.patientzerorpa.appservices.gmx.pages;

import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

@Slf4j
public class SignInPage extends GmxPage{

	private Pattern logo;
	private Pattern freeMailSection;
	private Pattern emailAddressField;
	private Pattern passworField;
	private Pattern loginButton;

	public SignInPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);

		logo = new Pattern(img("gmx.logo")).similar(matchSimilar);
		freeMailSection = new Pattern(img("gmx.signinpage.freeMailSection")).similar(matchSimilar);
		emailAddressField = new Pattern(img("gmx.signinpage.emailAddressField")).similar(matchSimilar);
		passworField = new Pattern(img("gmx.signinpage.passworField")).similar(matchSimilar);
		loginButton = new Pattern(img("gmx.signinpage.loginButton")).similar(matchSimilar);
	}

	public HomePage signIn(String username, String password) {
		try{

			if (!assertPage(new Pattern[]{logo, freeMailSection})) {
				throw new FindFailed("page assertion failed");
			}

			click(emailAddressField);
			click();
			paste(username);

			click(passworField);
			paste(password);

			click(loginButton);

		} catch(FindFailed findFailed){
			findFailed.printStackTrace();
		}
		return new HomePage( screen, pageProperties );
	}

}
