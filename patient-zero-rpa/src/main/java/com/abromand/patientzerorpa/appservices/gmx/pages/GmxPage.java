package com.abromand.patientzerorpa.appservices.gmx.pages;

import com.abromand.patientzerorpa.appservices.base.SikuliXPageObject;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Properties;

class GmxPage extends SikuliXPageObject {

	private Double pageTimeout;
	private Double actionTimeout;
	Double matchSimilar;

	GmxPage(Screen screen, Properties pageProperties) {
		super(screen, pageProperties);
		this.pageTimeout = Double.parseDouble( getProperty( "gmx.page.timeout" ) );
		this.actionTimeout = Double.parseDouble( getProperty( "gmx.action.timeout" ) );
		this.matchSimilar = Double.parseDouble( getProperty( "gmx.match.similar" ) );
	}

	void click() throws FindFailed {
		screen.click();
		screen.wait( actionTimeout );
	}

	void click(Pattern pattern) throws FindFailed {
		screen.click(pattern);
		screen.wait( actionTimeout );
	}

	void click(Match match) throws FindFailed {
		screen.click(match);
		screen.wait( actionTimeout );
	}

	void paste(String string) throws FindFailed{
		screen.paste(string);
		screen.wait( actionTimeout );
	}

	Boolean assertPage(Pattern[] patterns) {
		Match assertMatch;
		for(Pattern pattern : patterns){
			assertMatch = screen.exists(pattern, pageTimeout);
			assertMatch.highlight( actionTimeout.intValue() );

		}
		return true;
	}

	void singleClick(Pattern button) {
		try{
			if (!assertPage(new Pattern[]{button})) {
				throw new FindFailed("page assertion failed");
			}
			click(button);
		} catch(FindFailed findFailed){
			findFailed.printStackTrace();
		}
	}
}
