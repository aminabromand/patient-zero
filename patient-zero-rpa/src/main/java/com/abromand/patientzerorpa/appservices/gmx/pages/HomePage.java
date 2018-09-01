package com.abromand.patientzerorpa.appservices.gmx.pages;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

public class HomePage extends SignedInPage {
	private Pattern emailButton;

	HomePage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);
		emailButton = new Pattern(img("gmx.homepage.emailButton")).similar(0.9);
	}

	public EmailPage switchToEmail() {
		singleClick( emailButton );
		return new EmailPage( screen, pageProperties );
	}
}
