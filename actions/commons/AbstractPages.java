package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AbstractPages {
	WebElement element;
	
	public void openAnyUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPreviousPage(WebDriver driver) {
		driver.navigate().forward();
		;
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextInAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// WebElement
	public void clickToElement(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		element.click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locatorXpath, String valueToInput) {
		element = driver.findElement(By.xpath(locatorXpath));
		element.sendKeys(valueToInput);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locatorXpath, String value) {
		element = driver.findElement(By.xpath(locatorXpath));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
}
