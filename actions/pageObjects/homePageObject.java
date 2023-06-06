package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.homePageUI;
import commons.AbstractPages;

public class homePageObject extends AbstractPages{
	private WebDriver driver;

	public homePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Home page"+ driver.toString());
	}

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
