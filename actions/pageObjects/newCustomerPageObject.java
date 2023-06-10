package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.newCustomerUI;
import commons.AbstractPages;

public class newCustomerPageObject extends AbstractPages {
	private WebDriver driver;

	public newCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Login page"+ driver.toString());
	}

//	public void clickToNewCustomerLink() {
//		waitForElementVisible(driver, newCustomerUI.NEW_CUSTOMER_BUTTON);
//		clickToElement(driver, newCustomerUI.NEW_CUSTOMER_BUTTON);
//	}

	public void sendkeyTabToCustomerName() {
		sendKeyboardToElement(driver, newCustomerUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgCusNameDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_CUSTOMER_NAME);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_CUSTOMER_NAME);
	}

	public void sendKeyTabToDateOfBirth() {
		sendKeyboardToElement(driver, newCustomerUI.DATE_OF_BIRTH, Keys.TAB);
	}

	public boolean isEmptyMsgDOBDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_DATE_OF_BIRTH);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_DATE_OF_BIRTH);
	}

	public void sendKeyTabAddress() {
		sendKeyboardToElement(driver, newCustomerUI.ADDRESS_AREABOX, Keys.TAB);
	}

	public boolean isEmptyMsgAddressDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_ADDRESS_AREABOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_ADDRESS_AREABOX);
	}

	public void sendKeyTabToCity() {
		sendKeyboardToElement(driver, newCustomerUI.CITY_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgCityDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_CITY_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_CITY_TEXTBOX);
	}

	public void sendKeyTabState() {
		sendKeyboardToElement(driver, newCustomerUI.STATE_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgStateDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_STATE_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_STATE_TEXTBOX);
	}

	public void sendKeyTabPIN() {
		sendKeyboardToElement(driver, newCustomerUI.PIN_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgPINDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_PIN_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_PIN_TEXTBOX);
	}

	public void sendKeyMobileNumberPIN() {
		sendKeyboardToElement(driver, newCustomerUI.MOBILE_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgMobileNumberDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_MOBILE_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_MOBILE_TEXTBOX);
	}

	public void sendKeyEmailNumberPIN() {
		sendKeyboardToElement(driver, newCustomerUI.EMAIL_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgEmailNumberDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_EMAIL_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_EMAIL_TEXTBOX);
	}

	public void sendKeyPasswordNumberPIN() {
		sendKeyboardToElement(driver, newCustomerUI.PASSWORD_TEXTBOX, Keys.TAB);

	}

	public boolean isEmptyMsgPasswordNumberDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_MSG_PASSWORD_TEXTBOX);
		return isControlDisplayed(driver, newCustomerUI.ERR_MSG_PASSWORD_TEXTBOX);
	}

	public void inputToCustomerName(String cusNameToInput) {
		sendKeyToElement(driver, newCustomerUI.CUSTOMER_NAME_TEXTBOX, cusNameToInput);
	}

	public boolean isNumericNameErrDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_NUMERIC_CUSTOMER_NAME);
		return isControlDisplayed(driver, newCustomerUI.ERR_NUMERIC_CUSTOMER_NAME);
	}

	public boolean isSpecialNameErrDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_SPECIAL_CUSTOMER_NAME);
		return isControlDisplayed(driver, newCustomerUI.ERR_SPECIAL_CUSTOMER_NAME);
	}

	public void clearTextInCustomerName() {
		clearTextInElement(driver, newCustomerUI.CUSTOMER_NAME_TEXTBOX);
	}

	public void sendSpaceToCustomerName() {
		sendKeyboardToElement(driver, newCustomerUI.CUSTOMER_NAME_TEXTBOX, Keys.SPACE);
	}

	public boolean isNumericErrDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_NUMERIC_CUSTOMER_NAME);
		return isControlDisplayed(driver, newCustomerUI.ERR_NUMERIC_CUSTOMER_NAME);
	}

	public void sendSpaceToAddress() {
		sendKeyboardToElement(driver, newCustomerUI.ADDRESS_AREABOX, Keys.SPACE);
	}

	public boolean isErrFirstBlankMsgDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_FIRSTBLANK_ADDRESS);
		return isControlDisplayed(driver, newCustomerUI.ERR_FIRSTBLANK_ADDRESS);
	}

	public void clearTextInAddress() {
		clearTextInElement(driver, newCustomerUI.ADDRESS_AREABOX);
	}

	public void inputToCity(String numericInput) {
		sendKeyToElement(driver, newCustomerUI.CITY_TEXTBOX, numericInput);
	}

	public boolean isNumericMsgCityDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_NUMERIC_CITY);
		return isControlDisplayed(driver, newCustomerUI.ERR_NUMERIC_CITY);
	}

	public void sendSpaceToCity() {
		sendKeyboardToElement(driver, newCustomerUI.CITY_TEXTBOX, Keys.SPACE);
	}

	public boolean isFirstSpaceMsgCityDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_FIRTBLANK_CITY);
		return isControlDisplayed(driver, newCustomerUI.ERR_FIRTBLANK_CITY);
	}

	public boolean isFirstSpaceNameErrDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_FIRSTBLANK_CUSTOMER_NAME);
		return isControlDisplayed(driver, newCustomerUI.ERR_FIRSTBLANK_CUSTOMER_NAME);

	}

	public void clearTextInCity() {
		clearTextInElement(driver, newCustomerUI.CITY_TEXTBOX);
	}

	public void inputToState(String numericInput) {
		sendKeyToElement(driver, newCustomerUI.STATE_TEXTBOX, numericInput);
	}

	public boolean isNumericMsgStateDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_NUMERIC_STATE);
		return isControlDisplayed(driver, newCustomerUI.ERR_NUMERIC_STATE);
	}

	public void sendSpaceToState() {
		sendKeyboardToElement(driver, newCustomerUI.STATE_TEXTBOX, Keys.SPACE);
	}

	public boolean isSpaceMsgStateDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_FIRTBLANK_STATE);
		return isControlDisplayed(driver, newCustomerUI.ERR_FIRTBLANK_STATE);
	}

	public void inputToPin(String numericInput) {
		sendKeyToElement(driver, newCustomerUI.PIN_TEXTBOX, numericInput);
	}

	public boolean isCharMsgPinDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_CHAR_PIN);
		return isControlDisplayed(driver, newCustomerUI.ERR_CHAR_PIN);
	}

	public boolean isPinLesserThan6MsgStateDisplayed() {
		waitForElementVisible(driver, newCustomerUI.ERR_LESSER_6_DIGIT_PIN);
		return isControlDisplayed(driver, newCustomerUI.ERR_LESSER_6_DIGIT_PIN);
	}

	public void reloadNewCustomerPage() {
		driver.navigate().refresh();
	}

	public void clearTextInState() {
		clearTextInElement(driver, newCustomerUI.STATE_TEXTBOX);
	}

	public void clearTextInPin() {
		clearTextInElement(driver, newCustomerUI.PIN_TEXTBOX);
	}

	public void checkToGender() {
		clickToElement(driver, newCustomerUI.GENDER_CHECKBOX);
	}

	public void inputToDateOfBirth(String dob) {
		sendKeyToElement(driver, newCustomerUI.DATE_OF_BIRTH, dob);
	}

	public void inputToAddress(String address) {
		sendKeyToElement(driver, newCustomerUI.ADDRESS_AREABOX, address);
	}

	public void inputToMobile(String mobile) {
		sendKeyToElement(driver, newCustomerUI.MOBILE_TEXTBOX, mobile);
	}

	public void inputToEmail(String emailInput) {
		sendKeyToElement(driver, newCustomerUI.EMAIL_TEXTBOX, emailInput);
		
	}

	public void inputToPassword(String password) {
		sendKeyToElement(driver, newCustomerUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToSubmitButton() {
		clickToElement(driver, newCustomerUI.SUBMIT_BUTTON);
	}

	public void clickOKToAccepAlert() {
		acceptAlert(driver);
	}

	public String getCustomerID() {
		return getTextOfElement(driver, newCustomerUI.CUSTOMER_ID);
	}

}
