package com.abromand.patientzerorpa.appservices.gmx.pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

public class WriteEmailPage extends SignedInPage {
	private Pattern emailToField;
	private Pattern activeEmailToField;
	private Pattern emailSubjectField;
	private Pattern emailBodyField;
	private Pattern emailSendButton;

	WriteEmailPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);

		emailToField = new Pattern(img("gmx.writeemailpage.emailToField")).similar(0.9);
		activeEmailToField = new Pattern(img("gmx.writeemailpage.activeEmailToField")).similar(0.9);
		emailSubjectField = new Pattern(img("gmx.writeemailpage.emailSubjectField")).similar(0.9);
		emailBodyField = new Pattern(img("gmx.writeemailpage.emailBodyField")).similar(0.9);
		emailSendButton = new Pattern(img("gmx.writeemailpage.emailSendButton")).similar(0.9);
	}

	public EmailPage sendMail(String emailTo, String subject, String emailBody) {
		try{

			if (!assertPage(new Pattern[]{emailSendButton})) {
				throw new FindFailed("page assertion failed");
			}

			click(screen.findBest( emailToField, activeEmailToField ));
			paste(emailTo);

			click(emailSubjectField);
			paste(subject);

			click(emailBodyField);
			paste(emailBody);

			click(emailSendButton);

		} catch(FindFailed findFailed){
			findFailed.printStackTrace();
		}
		return new EmailPage( screen, pageProperties );
	}
}
