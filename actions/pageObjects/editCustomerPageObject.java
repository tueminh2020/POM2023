package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class editCustomerPageObject extends AbstractPages{
	private WebDriver driver;

	public editCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Edit customer page"+ driver.toString());

	}

}
