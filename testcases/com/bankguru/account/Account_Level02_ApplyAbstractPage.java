package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Account_Level02_ApplyAbstractPage {
	WebDriver driver;
	String emailInput = "tranhuyentb" + randomNumber() + "@yopmail.com";
	String loginPageUrl;
	String userInfor;
	String passInfor;
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_registerToSystem() {
		driver.get("https://demo.guru99.com/v4/");
		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
		loginPageUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailInput);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();	
		userInfor = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		passInfor = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
	}
	
	@Test
	public void TC_02_loginToSystem() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userInfor);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passInfor);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
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
