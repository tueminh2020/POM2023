package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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

public class Account_Level_11_ShareClass_CloseBrowser_WebDriverManage extends AbstractTest{
	WebDriver driver;
	String emailInput, customerName, dob, address, city, state, pin, mobile, password;
	String customerIDLabel, CustomerNameLabel, GenderLabel, AddressLabel, StateLabel, PinLabel, MobileLabel, EmailLabel;
	String numericInput = "a" + randomNumber();
	String loginPageUrl;
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
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManage.getLoginPage(driver);
		emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
	}

	@Test
	public void TC_02_loginToSystem() {
		log.info("Login - Step 02: Verify loginform displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Login - Step 03: Input to userID");
		loginPage.inputToUserIDTextbox(Account_Common_RegisterToSystem.userInfor);
		
		log.info("Login - Step 04: Input to password");
		loginPage.inputToPasswordTextbox(Account_Common_RegisterToSystem.passInfor);
		
		log.info("Login - Step 05: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 06: Verify welcome msg and userID displayed");
		verifyTrue(homePage.isWelcomeMsgDisplayed());
		verifyTrue(homePage.isUserIDDisplayed(Account_Common_RegisterToSystem.userInfor));
	}	
	
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
