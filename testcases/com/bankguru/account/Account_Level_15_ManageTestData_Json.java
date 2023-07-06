package com.bankguru.account;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonParseException;

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

public class Account_Level_15_ManageTestData_Json extends AbstractTest {
	WebDriver driver;
	String emailInput, customerName, dob, address, city, state, pin, mobile, password, customerID;
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
	CustomerDataJson customerData;

	String pinErr = "123";

	@Parameters({ "browser", "CUSTOMER_PATH" })
	@BeforeTest
	public void beforeTest(String browserName, String dataFilePath)
			throws JsonMappingException, JsonParseException, IOException {
		driver = openMultiBrowser(browserName);
		customerData = CustomerDataJson.get(dataFilePath);

		loginPage = PageFactoryManage.getLoginPage(driver);

	}

	@Test
	public void TC_01_registerToSystem() {
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();

		// registerPage = new registerPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(customerData.email + "@gmail.com");
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
	public void TC_04_CreateNewCustomer() {
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManage.getNewCustomerPage(driver);
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getcustomerName(), "name");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getDOB(), "dob");
		newCustomerPage.inputToAddressbox(customerData.getAddress());
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getCity(), "city");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getState(), "state");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getPin(), "pinno");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getPhone(), "telephoneno");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getEmail(), "emailid");
		newCustomerPage.inputToDynamicTextbox(driver, customerData.getPassword(), "password");
		Assert.assertTrue(newCustomerPage.isCustomerRegisterSuccessDisplayed());
		customerID = newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "Customer ID");
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "Address"));
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "City"));
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "State"));
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "Pin"));
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "Mobile No."));
//		Assert.assertEquals(customerName, newCustomerPage.getTextOfSuccessFormCreateNewCus(driver, "Email"));

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
