package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class loginPageObject extends AbstractPages {
	private WebDriver driver;


	public loginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Login page"+ driver.toString());

	}
	public boolean isLoginFormDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public registerPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		//return new registerPageObject(driver);
		return PageFactoryManage.getRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String userInfor) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userInfor);
	}

	public void inputToPasswordTextbox(String passInfor) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passInfor);

	}

	public homePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		//return new homePageObject(driver);
		return PageFactoryManage.getHomePage(driver);
	}

}
