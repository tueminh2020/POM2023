package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.editCustomerPageObject;
import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.newCustomerPageObject;
import pageObjects.registerPageObject;


public class PageFactoryManage {
	
	public static loginPageObject getLoginPage(WebDriver driver) {
		return new loginPageObject(driver);
	}
	
	public static registerPageObject getRegisterPage(WebDriver driver) {
		return new registerPageObject(driver);
	}

	public static homePageObject getHomePage(WebDriver driver) {
		return new homePageObject(driver);
	}

	public static newCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new newCustomerPageObject(driver);
	}

	public static editCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new editCustomerPageObject(driver);
	}

	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}

	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}

	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}


}
