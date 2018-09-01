package com.abromand.patientzerorpa.appservices.gmx.pages;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

public class EmailPage extends SignedInPage {
	private Pattern writeEmailButton;

	EmailPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);
		writeEmailButton = new Pattern(img("gmx.emailpage.writeEmailButton")).similar(matchSimilar);
	}

	public WriteEmailPage writeMail() {
		singleClick( writeEmailButton );
		return new WriteEmailPage( screen, pageProperties );
	}
}
