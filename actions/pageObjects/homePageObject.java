package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.homePageUI;
import commons.AbstractPages;

public class homePageObject extends AbstractPages{

	public homePageObject(WebDriver mappingDriver) {
		this.driver = mappingDriver;
	}

	private WebDriver driver;
	public boolean isWelcomeMsgDisplayed() {
		waitForElementVisible(driver, homePageUI.WELCOME_MSG);
		return isControlDisplayed(driver, homePageUI.WELCOME_MSG);
	}

	public boolean isUserIDDisplayed(String userInfor) {
		String USER_ID_FORMAT = String.format(homePageUI.USER_ID_TEXT, userInfor);
		waitForElementVisible(driver, USER_ID_FORMAT);
		return isControlDisplayed(driver, USER_ID_FORMAT);
	}

}
