package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import commons.AbstractPages;
import commons.PageFactoryManage;

public class FundTransferPageObject extends AbstractPages {
	private WebDriver driver;

	public FundTransferPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("FundTransfer Page" + driver.toString());
	}

//	public homePageObject openHomePage() {
//		waitForElementVisible(driver, FundTransferPageUI.HOME_PAGE_LINK);
//		clickToElement(driver, FundTransferPageUI.HOME_PAGE_LINK);
//		return PageFactoryManage.getHomePage(driver);
//	}
}
