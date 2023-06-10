package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class registerPageObject extends AbstractPages {
	private WebDriver driver;

	public registerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("regiter page"+ driver.toString());

	}

	public boolean isRegisterPageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		return isControlDisplayed(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
	}

	public void inputToEmailIDTextbox(String emailInput) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, emailInput);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDInfor() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextOfElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordInfor() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextOfElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public loginPageObject openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		//return new loginPageObject(driver);
		return PageFactoryManage.getLoginPage(driver);
	}

}
