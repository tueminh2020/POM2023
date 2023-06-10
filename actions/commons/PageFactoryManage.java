package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.newCustomerPageObject;
import pageObjects.registerPageObject;


public class PageFactoryManage {
	private static loginPageObject loginPage;
	private static homePageObject homePage;
	private static registerPageObject registerPage;
	private static newCustomerPageObject newCustomerPage;
	
	public static loginPageObject getLoginPage(WebDriver driver) {
		if(loginPage==null)
		{
			loginPage = new loginPageObject(driver);
		}
		return loginPage;
	}
	
	public static registerPageObject getRegisterPage(WebDriver driver) {
		if(registerPage==null)
		{
			registerPage = new registerPageObject(driver);
		}
		return registerPage;
	}

	public static homePageObject getHomePage(WebDriver driver) {
		if(homePage==null)
		{
			homePage = new homePageObject(driver);
		}
		return homePage;
	}

	public static newCustomerPageObject getNewCustomerPage(WebDriver driver) {
		if(newCustomerPage ==null) {
			newCustomerPage = new newCustomerPageObject(driver);
		}
		return newCustomerPage;
	}


}
