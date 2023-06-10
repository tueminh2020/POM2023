package customer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.editCustomerPageObject;
import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.newCustomerPageObject;
import pageObjects.registerPageObject;

public class editCustomer {
	WebDriver driver;
	loginPageObject loginPage;
	registerPageObject registerPage;
	homePageObject homePage;
	newCustomerPageObject newCustomerPage;
	editCustomerPageObject editCustomerPage;

	@BeforeTest
	public void beforeTest() {
//		//System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//		driver = new FirefoxDriver();
//		System.out.println(driver.toString());
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://demo.guru99.com/v4/");
//		//emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
		//editCustomerPage = newCustomerPage.getEditCustomerPage(driver);
		homePage = newCustomerPage.clickToManagerLink();
		editCustomerPage = homePage.clickToEditCustomer();
	}

	@Test(priority = 1)
	public void TC_01_registerToSystem() {
		
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
