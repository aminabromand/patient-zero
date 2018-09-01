package com.abromand.patientzerorpa.appservices.gmx.pages;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

public class SignedInPage extends GmxPage {
	private Pattern logoutButton;

	SignedInPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);

		logoutButton = new Pattern(img("gmx.signedinpage.logoutButton")).similar(matchSimilar);
	}

	public void logout() {
		singleClick( logoutButton );
	}
}
