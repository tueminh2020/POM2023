package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPages;
import pageObjects.homePageObject;
import pageObjects.loginPageObject;
import pageObjects.registerPageObject;

public class Account_Level03_PageObject {
	WebDriver driver;
	String emailInput;
	String loginPageUrl, userInfor, passInfor;
	AbstractPages abstractPage;
	loginPageObject loginPage;
	registerPageObject registerPage;
	homePageObject homePage;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
		emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
	}

	@Test
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
	}
	
	@Test
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
		
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
