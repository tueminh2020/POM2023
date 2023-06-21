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

public class Account_Level_10_Assert_Verify_Log_Report extends AbstractTest{
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
		log.info("Register - Step 01: Verify login Form displayed");
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		
		log.info("Register - Step 02: Click to here link");
		registerPage = loginPage.clickToHereLink();

		// registerPage = new registerPageObject(driver);
		log.info("Register - Step 03: Vefiry register form displayed");
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Register - Step 04: Input to emailID textbox");
		registerPage.inputToEmailIDTextbox(emailInput);
		
		log.info("Register - Step 05: Click to submit button");
		registerPage.clickToLoginButton();
		
		log.info("Register - Step 06: Get ra userID and Password");
		userInfor = registerPage.getUserIDInfor();
		passInfor = registerPage.getPasswordInfor();
		System.out.println(userInfor + "/" + passInfor);
		System.out.println(loginPageUrl);

	}
	@Test
	public void TC_02_loginToSystem() {
		log.info("Login - Step 01: Open login form");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		log.info("Login - Step 02: Verify loginform displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Login - Step 03: Input to userID");
		loginPage.inputToUserIDTextbox(userInfor);
		
		log.info("Login - Step 04: Input to password");
		loginPage.inputToPasswordTextbox(passInfor);
		
		log.info("Login - Step 05: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 06: Verify welcome msg and userID displayed");
		verifyTrue(homePage.isWelcomeMsgDisplayed());
		verifyTrue(homePage.isUserIDDisplayed(userInfor));


	}

	@Test
	public void TC_03_OpenMultiPage() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(userInfor);
		loginPage.inputToPasswordTextbox(passInfor);
		homePage = loginPage.clickToLoginButton();

		verifyTrue(homePage.isWelcomeMsgDisplayed());
		verifyTrue(homePage.isUserIDDisplayed(userInfor));

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
