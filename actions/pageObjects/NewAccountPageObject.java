package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.NewAccountPageUI;
import bankguru.homePageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class NewAccountPageObject extends AbstractPages{
	private WebDriver driver;

	public NewAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("New Account Page"+ driver.toString());
	}

//	public DepositPageObject openDepositPage() {
//		waitForElementVisible(driver, NewAccountPageUI.DEPOSIT_LINK);
//		clickToElement(driver, NewAccountPageUI.DEPOSIT_LINK);
//		return PageFactoryManage.getDepositPage(driver);
//	}
}
