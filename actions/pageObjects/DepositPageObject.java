package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
import bankguru.homePageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class DepositPageObject extends AbstractPages{
	private WebDriver driver;

	public DepositPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Deposit Page"+ driver.toString());
	}
//
//	public FundTransferPageObject openFundTransferPage() {
//		waitForElementVisible(driver, DepositPageUI.FUND_TRANSFER_LINK);
//		clickToElement(driver, DepositPageUI.FUND_TRANSFER_LINK);
//		return PageFactoryManage.getFundTransferPage(driver);
//	}
}
