package com.mycompany.web.pages.herokuwebsite;


import com.mycompany.web.utilities.BrowserWindowUtilities;
import com.mycompany.web.utilities.ValidationUtils;

public class NewWindow {

	private final String TITLE = "New Window";
	
	public void validatePageTitle(ValidationUtils utility) {
		utility.validateWindowTitle(TITLE);
	}

	public void switchToThisPage(BrowserWindowUtilities browserUtils) {
		browserUtils.switchToTitle(TITLE);
	}
}
