package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPages {
	WebElement element;
	List<WebElement> elements;
	JavascriptExecutor jsExecuter;
	WebDriverWait waitExplicit;
	Actions action;
	By byLocator;
	long shortTimeout =5;
	long longTimeout = 30;
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

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedValue) throws Exception {
		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
		jsExecuter.executeScript("arguments[0].click();", parentDropdown);

		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement childElement : allItems) {
			if (childElement.getText().contains(expectedValue)) {
				jsExecuter.executeScript("arguments[0].scrollIntoView(true);", childElement);
				Thread.sleep(1500);
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecuter.executeScript("arguments[0].click();", childElement);

				}
				Thread.sleep(3000);
				break;
			}
		}
	}

	public String getAtributeValue(WebDriver driver, String locatorXpath, String atributeName) {
		element = driver.findElement(By.xpath(locatorXpath));
		return element.getAttribute(atributeName);
	}

	public int countElementNumber(WebDriver driver, String locatorXpath) {
		elements = driver.findElements(By.xpath(locatorXpath));
		return elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckTheCheckbox(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		return element.isSelected();
	}

	public boolean isControlEnable(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		return element.isEnabled();
	}

	// Switch if have only 2 window
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	// Switch if have > 2 window
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWindowWithoutParentWindows(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToIframe(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		driver.switchTo().frame(element);
	}

	public void backToTopWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// User Actions

	public void hoverMouseToElement(WebDriver driver, String locatorXpath) {
		element = driver.findElement(By.xpath(locatorXpath));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void sendKeyboardKeyToElement(WebDriver driver, String locatorXpath, Keys key) {
		element = driver.findElement(By.xpath(locatorXpath));
		action = new Actions(driver);
		action.sendKeys(element, key);
	}

	public void highlightElement(WebDriver driver, String locatorXpath) {
		jsExecuter = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locatorXpath));
		jsExecuter.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript(javaSript);
	}

	public Object clickToElementByJS(WebDriver driver, String xpathName) {
		element = driver.findElement(By.xpath(xpathName));
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript("arguments[0].click();", element);
	}

	public Object sendkeyToElementByJS(WebDriver driver, String xpathName, String value) {
		element = driver.findElement(By.xpath(xpathName));
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public Object removeAttributeInDOM(WebDriver driver, String xpathName, String attribute) {
		element = driver.findElement(By.xpath(xpathName));
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object scrollToBottomPage(WebDriver driver) {
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object navigateToUrlByJS(WebDriver driver, String url) {
		jsExecuter = (JavascriptExecutor) driver;
		return jsExecuter.executeScript("window.location = '" + url + "'");
	}

	public void waitForElementPresence(WebDriver driver, String locatorXpath) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locatorXpath);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locatorXpath) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locatorXpath);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
	}

	public void waitForElementClickAble(WebDriver driver, String locatorXpath) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locatorXpath);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	public void waitForElementInvisible(WebDriver driver, String locatorXpath) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locatorXpath);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}

	public void waitForAlertPresent(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
