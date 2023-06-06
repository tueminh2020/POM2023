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

import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.newCustomerPageObject;
import pageObjects.registerPageObject;

public class newCustomer {
	WebDriver driver;
	String emailInput, customerName, dob, address, city, state, pin, mobile, password;
	String customerIDLabel, CustomerNameLabel, GenderLabel, AddressLabel, StateLabel, PinLabel, MobileLabel, EmailLabel;
	String numericInput = "a" + randomNumber();
	String loginPageUrl, userInfor, passInfor;
	loginPageObject loginPage;
	registerPageObject registerPage;
	homePageObject homePage;
	newCustomerPageObject newCustomerPage;
	String pinErr = "123";

	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new FirefoxDriver();
		System.out.println(driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
		customerName = "Tran Thi Huyen";
		dob = "22/10/2017";
		address ="123 Tay Ho Ha Noi";
		city = "Ha Noi";
		state ="Viet Nam";
		pin="000000";
		mobile ="098727839";
		password ="12345678";
	}

	@Test(priority = 1)
	public void TC_01_registerToSystem() {
		loginPage = new loginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();

		registerPage = new registerPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(emailInput);
		registerPage.clickToLoginButton();
		userInfor = registerPage.getUserIDInfor();
		passInfor = registerPage.getPasswordInfor();
		System.out.println(userInfor + "/" + passInfor);
		System.out.println(loginPageUrl);

	}

	@Test(priority = 2)
	public void TC_02_loginToSystem() {
		registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage = new loginPageObject(driver);

		loginPage.inputToUserIDTextbox(userInfor);
		loginPage.inputToPasswordTextbox(passInfor);
		loginPage.clickToLoginButton();

		homePage = new homePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMsgDisplayed());
		Assert.assertTrue(homePage.isUserIDDisplayed(userInfor));

	}

	@Test(priority = 3)
	public void TC_03_CusNameEmpty() throws InterruptedException {
		newCustomerPage = new newCustomerPageObject(driver);
		newCustomerPage.clickToNewCustomerLink();
		newCustomerPage.sendkeyTabToCustomerName();
		Assert.assertTrue(newCustomerPage.isEmptyMsgCusNameDisplayed());
		Thread.sleep(1000);

	}

	//@Test(priority = 4)
	public void TC_04_CusNameCannotNummeric() throws Exception {
		newCustomerPage.inputToCustomerName(numericInput);
		Assert.assertTrue(newCustomerPage.isNumericNameErrDisplayed());
		newCustomerPage.clearTextInCustomerName();
		Thread.sleep(3000);
	}

	//@Test(priority = 5)
	public void TC_05_CusNameCannotFirstSpaceChar() {
		newCustomerPage.sendSpaceToCustomerName();
		Assert.assertTrue(newCustomerPage.isFirstSpaceNameErrDisplayed());
		newCustomerPage.clearTextInCustomerName();
	}

	//@Test(priority = 6)
	public void TC_06_CusNameSpecialChar() {
		newCustomerPage.inputToCustomerName(emailInput);
		Assert.assertTrue(newCustomerPage.isSpecialNameErrDisplayed());
		newCustomerPage.clearTextInCustomerName();
	}

	//@Test(priority = 7)
	public void TC_07_AddessNotEmpty() {
		newCustomerPage.sendKeyTabAddress();
		Assert.assertTrue(newCustomerPage.isEmptyMsgAddressDisplayed());
	}

//	@Test(priority = 8)
	public void TC_07_AddessHaveFirstBlank() {
		newCustomerPage.sendSpaceToAddress();
		Assert.assertTrue(newCustomerPage.isErrFirstBlankMsgDisplayed());
		newCustomerPage.clearTextInAddress();
	}

//	@Test(priority = 9)
	public void cityCannotBeEmpty() {
		newCustomerPage.sendKeyTabToCity();
		Assert.assertTrue(newCustomerPage.isEmptyMsgCityDisplayed());
	}

	//@Test(priority = 10)
	public void cityCannotBeNumeric() {
		newCustomerPage.inputToCity(numericInput);
		Assert.assertTrue(newCustomerPage.isNumericMsgCityDisplayed());
		newCustomerPage.clearTextInCity();
	}

	//@Test(priority = 11)
	public void cityCannotFirstBlank() {
		newCustomerPage.sendSpaceToCity();
		Assert.assertTrue(newCustomerPage.isFirstSpaceMsgCityDisplayed());
		newCustomerPage.clearTextInCity();
	}

	//@Test(priority = 12)
	public void stateCannotBeEmpty() {
		newCustomerPage.sendKeyTabState();
		Assert.assertTrue(newCustomerPage.isEmptyMsgStateDisplayed());
	}
	
	//@Test(priority=13)
	public void stateCannotBeNumeric() {
		newCustomerPage.inputToState(numericInput);
		Assert.assertTrue(newCustomerPage.isNumericMsgStateDisplayed());
		newCustomerPage.clearTextInState();
	}
	
	//@Test(priority =14)
	public void stateWithFirstBlank() {
		newCustomerPage.sendSpaceToState();
		Assert.assertTrue(newCustomerPage.isSpaceMsgStateDisplayed());
		newCustomerPage.clearTextInState();

	}


	//@Test(priority = 15)
	public void pinCannotBeEmpty() {
		newCustomerPage.sendKeyTabPIN();
		Assert.assertTrue(newCustomerPage.isEmptyMsgPINDisplayed());
	}
	
	//@Test(priority=16)
	public void pinMustBeNumeric() throws InterruptedException {
		newCustomerPage.inputToPin(numericInput);
		newCustomerPage.sendKeyTabPIN();
		Assert.assertTrue(newCustomerPage.isCharMsgPinDisplayed());
		Thread.sleep(1000);
		newCustomerPage.clearTextInPin();
	}
	
	//@Test(priority =17)
	public void pinLesserThan6() {
		newCustomerPage.inputToPin(pinErr);
		newCustomerPage.sendKeyTabPIN();
		Assert.assertTrue(newCustomerPage.isPinLesserThan6MsgStateDisplayed());
		newCustomerPage.clearTextInPin();
	}
	
	@Test(priority =18)
	public void CreateCustomerSuccess() {
		newCustomerPage.reloadNewCustomerPage();
		newCustomerPage.inputToCustomerName(customerName);
		newCustomerPage.checkToGender();
		newCustomerPage.inputToDateOfBirth(dob);
		newCustomerPage.inputToAddress(address);
		newCustomerPage.inputToCity(city);
		newCustomerPage.inputToState(state);
		newCustomerPage.inputToPin(pin);
		newCustomerPage.inputToMobile(mobile);
		newCustomerPage.inputToEmail(emailInput);
		newCustomerPage.inputToPassword(password);
		newCustomerPage.clickToSubmitButton();
		customerIDLabel = newCustomerPage.getCustomerID();
		System.out.println("Customer ID : " + customerIDLabel);
		//newCustomerPage.clickOKToAccepAlert();
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
