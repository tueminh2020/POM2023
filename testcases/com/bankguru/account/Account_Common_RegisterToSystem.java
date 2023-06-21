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

public class Account_Common_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	public static String userInfor, passInfor;
	loginPageObject loginPage;
	registerPageObject registerPage;
	String emailInput, loginPageUrl;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManage.getLoginPage(driver);
		emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
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
		driver.quit();

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
