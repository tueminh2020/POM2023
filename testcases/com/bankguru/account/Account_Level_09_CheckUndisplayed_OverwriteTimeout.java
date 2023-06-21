package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManage;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.editCustomerPageObject;
import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.newCustomerPageObject;
import pageObjects.registerPageObject;

public class Account_Level_09_CheckUndisplayed_OverwriteTimeout extends AbstractTest{
	WebDriver driver;
	String emailInput, customerName, dob, address, city, state, pin, mobile, password;
	String customerIDLabel, CustomerNameLabel, GenderLabel, AddressLabel, StateLabel, PinLabel, MobileLabel, EmailLabel;
	String numericInput = "a" + randomNumber();
	String loginPageUrl, userInfor, passInfor;
	loginPageObject loginPage;
	registerPageObject registerPage;
	homePageObject homePage;
	newCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	DepositPageObject depositPage;
	FundTransferPageObject fundTransfer;
	editCustomerPageObject editCustomerPage;
	
	String pinErr = "123";

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManage.getLoginPage(driver);
		emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
		customerName = "Tran Thi Huyen";
		dob = "22/10/2017";
		address = "123 Tay Ho Ha Noi";
		city = "Ha Noi";
		state = "Viet Nam";
		pin = "000000";
		mobile = "098727839";
		password = "12345678";
	}

	@Test
	public void TC_01_registerToSystem() {
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();

		// registerPage = new registerPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(emailInput);
		registerPage.clickToLoginButton();
		userInfor = registerPage.getUserIDInfor();
		passInfor = registerPage.getPasswordInfor();
		System.out.println(userInfor + "/" + passInfor);
		System.out.println(loginPageUrl);

	}
	@Test
	public void TC_02_loginToSystem() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		// loginPage = new loginPageObject(driver);

		loginPage.inputToUserIDTextbox(userInfor);
		loginPage.inputToPasswordTextbox(passInfor);
		homePage = loginPage.clickToLoginButton();

		// homePage = new homePageObject(driver);
		Assert.assertTrue(homePage.isWelcomeMsgDisplayed());
		Assert.assertTrue(homePage.isUserIDDisplayed(userInfor));

//		loginPage = homePage.clickToLogoutLink();
//		Assert.assertTrue(loginPage.isLoginFormDisplayed());

	}

	@Test
	public void TC_03_OpenMultiPage() {
		Assert.assertTrue(homePage.isLoginFormUndisplayed());
		System.out.println("Check framne");
		Assert.assertTrue(homePage.isIframeUndisplayed());

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
